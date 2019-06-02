package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Account;
import com.example.demo.model.Release;
import com.example.demo.model.Sell;
import com.example.demo.model.Stock;
import com.example.demo.service.prod.ProdService;
import com.example.demo.service.release.ReleaseService;
import com.example.demo.service.sell.SellService;

@Controller
public class ReleaseController{
	
	@Autowired
	ReleaseService rlsService;
	
	@Autowired
	ProdService prodService;
	
	@Autowired
	SellService sellService;
	
	@GetMapping("/show_rls")
	public ModelAndView rls_Info(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int acnt_store_no = account.getStore_no();
		
		List<Release> rlsList = rlsService.getReleaseList();
		
		for(int i=0; i<rlsList.size(); i++) {
			int prod_no = rlsList.get(i).getProd_no();
			if(prodService.checkByProdNo(prod_no)) {
				rlsList.get(i).setProd_name(prodService.getNameByProdNo(prod_no));
			}
		}
		mav.addObject("rlsList",rlsList);
		
		
		mav.setViewName("release/show_rls");

		return mav;
	}
	
	@GetMapping("/show_sell")
	public ModelAndView sell_Info(ModelAndView mav) {
		
		List<Sell> sellList = sellService.getSellList();
		mav.addObject("sellList",sellList);
		
		mav.setViewName("release/show_sell");
		
		return mav;
	}
}