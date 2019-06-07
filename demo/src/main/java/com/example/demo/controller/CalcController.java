package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.model.Calc;
import com.example.demo.model.Sales;
import com.example.demo.service.calc.CalcService;
import com.example.demo.service.calc.SalesService;
import com.example.demo.service.store.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CalcController {

	@Autowired
	StoreInfoService storeInfoService;

	@Autowired
	SalesService salesService;

	@Autowired
	CalcService calcService;


	@GetMapping("/manage_sales")
	public ModelAndView manage_sales(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Sales> salesList = salesService.getSalesList(account.getStore_no());
		mav.addObject("store_no", account.getStore_no());
		mav.addObject("salesList", salesList);
		mav.setViewName("calc/manage_sales");

		return mav;
	}

	@PostMapping("/calculate_sales")
	public String calculate_sales(@RequestParam("sales_date") String salesdate, @RequestParam("store_no") int store_no) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date sales_date ;
		try{
			sales_date = sdf.parse(salesdate);
		}
		catch (ParseException e){
			return "redirect:/manage_sales";

		}

		Sales sales = new Sales(store_no,sales_date, salesService.calculateSales_amt(store_no,sales_date));

		if(salesService.isSalesExist(store_no, sales_date)) {
			salesService.updateSales(sales);
		}
		else
			salesService.insertSales(sales);

		return "redirect:/manage_sales";
	}

	@GetMapping("/manage_calc")
	public ModelAndView manage_calc(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Calc> calcList = calcService.getCalcList(account.getStore_no());
		mav.addObject("calcList", calcList);
		mav.setViewName("calc/manage_calc");

		return mav;
	}

	@GetMapping("/lookup_sales")
	public ModelAndView lookup_sales(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Integer> store_noList = storeInfoService.getStore_noList(account.getAdmin_no());

		List<Sales> salesList = new ArrayList<>();
		for( int store_no : store_noList )
			salesList.addAll(salesService.getSalesList(store_no));
		mav.addObject("salesList", salesList);
		mav.setViewName("calc/lookup_sales");

		return mav;
	}

	@GetMapping("/lookup_calc")
	public ModelAndView lookup_calc(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Integer> store_noList = storeInfoService.getStore_noList(account.getAdmin_no());

		List<Calc> calcList = new ArrayList<>();
		for(int store_no : store_noList)
			calcList.addAll(calcService.getCalcList(store_no));
		mav.addObject("calcList", calcList);
		mav.setViewName("calc/lookup_calc");

		return mav;
	}

}
