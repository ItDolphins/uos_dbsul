package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.SellInfo;
import com.example.demo.model.Account;
import com.example.demo.model.Admin;
import com.example.demo.model.Prod;
import com.example.demo.model.Stock;
import com.example.demo.service.stock.StockService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class StockController {
	
	@Autowired
	StockService releaseService;
	
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


	@GetMapping("/sell_product")
	public ModelAndView prod_Info(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int acnt_store_no = account.getStore_no();
		List<Stock> stockList = releaseService.getStockList(acnt_store_no);
		
		mav.addObject("stockList",stockList);
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
		
		public SellInfo toSellInfo() {
			return new SellInfo();
		}
	}
	
	@RequestMapping(value = "/product_sell_process", method = RequestMethod.POST)
	@ResponseBody
	public String product_sell_process(@RequestBody List<SellWrapper> requests) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int acnt_store_no = account.getStore_no();
		for(int i=0; i<requests.size(); i++) {
			SellWrapper sell = requests.get(i);
			Stock stock = releaseService.getStock(sell.getProd_no(), sell.getExpdate(),acnt_store_no);
			int changed_amount = stock.getStock_qnt() - sell.getAmount();
			releaseService.updateStock(stock, changed_amount);
		}
		return null;
		
	}
}
