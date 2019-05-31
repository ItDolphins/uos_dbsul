package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Account;
import com.example.demo.model.Admin;
import com.example.demo.model.Prod;
import com.example.demo.model.Stock;
import com.example.demo.service.release.ReleaseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class ReleaseController {
	
	@Autowired
	ReleaseService releaseService;
	
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
	
	@Autowired
	private ObjectMapper mapper;
	
	@RequestMapping(value = "/product_sell_process", method = RequestMethod.POST)
	@ResponseBody
	public String product_sell_process(@RequestBody List<Map<String, Object>> body) {
		System.out.println(body);
		
		return null;
		
	}
}
