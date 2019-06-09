package com.example.demo.controller;

import java.io.BufferedReader;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.service.store.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.DiscountStock;
import com.example.demo.dto.SellInfo;
import com.example.demo.model.Account;
import com.example.demo.model.Sell;
import com.example.demo.model.Stock;
import com.example.demo.service.prod.ProdService;
import com.example.demo.service.release.ReleaseService;
import com.example.demo.service.sell.SellService;
import com.example.demo.service.stock.StockService;

import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class StockController {
	
	@Autowired
	StockService stockService;

	@Autowired
	StoreInfoService storeInfoService;
	
	@Autowired
	ReleaseService releaseService;
	
	@Autowired
	ProdService prodService;
	
	@Autowired
	SellService sellSerivce;
	
	
	private String readJSONStringFromRequestBody(HttpServletRequest request){
	    StringBuffer json = new StringBuffer();
	    String line = null;
	 
	    try {
	        BufferedReader reader = request.getReader();
	        while((line = reader.readLine()) != null) {
	            json.append(line);
	        }
	 
	    }catch(Exception e) {
	        System.out.println("Error reading JSON string: " + e.toString());
	    }
	    return json.toString();
	}


	@GetMapping("/stock_manage")
	public ModelAndView stock_manage(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Integer> store_noList = storeInfoService.getStore_noList(account.getAdmin_no());

		List<Stock> stockList= new ArrayList<Stock>();

		for( int store_no : store_noList){
			stockList.addAll(stockService.getStockList(store_no));
		}
		mav.addObject("stockList",stockList);
		mav.setViewName("prod/stock_manage");

		return mav;
	}

	@GetMapping("/lookup_stock")
	public ModelAndView lookup_stock(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Stock> stockList= stockService.getStockList(account.getStore_no());
		mav.addObject("stockList",stockList);
		mav.setViewName("prod/lookup_stock");

		return mav;
	}

	@GetMapping("/sell_product")
	public ModelAndView prod_Info(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int acnt_store_no = account.getStore_no();
		List<Stock> stockList = stockService.getStockList(acnt_store_no);
		List<DiscountStock> discountStockList = stockService.getDiscountStockList(acnt_store_no);
		for(int i=0; i<discountStockList.size(); i++) {
			discountStockList.get(i).setProd_price(discountStockList.get(i).getProd_price() * (100 - discountStockList.get(i).getDc_rate()) / 100);
		}

		mav.addObject("stockList",stockList);
		mav.addObject("discountStockList",discountStockList);
		mav.setViewName("release/sell_product");

		return mav;
	}
	
	@Data
	@NoArgsConstructor
	public static class SellWrapper {
		private int prod_no;
		@DateTimeFormat(iso = ISO.DATE)
		private Date expdate;
		private int amount;
		private int price;
		
		public SellInfo toSellInfo() {
			return new SellInfo();
		}
	}
	
	@RequestMapping(value = "/product_sell_process", method = RequestMethod.POST)
	@ResponseBody
	public String product_sell_process(@RequestBody List<SellWrapper> requests) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String rls_code = "A";
		Sell sell = new Sell();
		Timestamp rls_date = new Timestamp(System.currentTimeMillis());
		int acnt_store_no = account.getStore_no();
		for(int i=0; i<requests.size(); i++) {
			SellWrapper sellItem = requests.get(i);
			Stock stock = stockService.getStock(sellItem.getProd_no(), sellItem.getExpdate(),acnt_store_no);
			int changed_amount = stock.getStock_qnt() - sellItem.getAmount();
			//재고 엔티티에 변한 수량을 반영
			stockService.updateStock(stock, changed_amount);
			//release 엔티티에 insert
			releaseService.insertRelease(stock, rls_code, rls_date,sellItem.getAmount());
			//판매 테이블에 insert하기 위한 작업
			sell.setRls_no(releaseService.getMaxRlsno());
			sell.setMember_no(3); //임의로 3번회원이라고 가정
			//sell.setSell_price(prodService.getPriceByProdNo(sellItem.getProd_no())* sellItem.getAmount());
			sell.setSell_price(sellItem.getPrice()* sellItem.getAmount());
			System.out.println(sellItem.getPrice());
			System.out.println(sellItem.getAmount());
			sellSerivce.insertSell(sell);
			
			//여기부터 마일리지 처리부분
			
		}
		return null;
		
	}
}