package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Account;
import com.example.demo.model.Prod;
import com.example.demo.model.Staff;
import com.example.demo.model.StoreInfo;
import com.example.demo.service.prod.ProdService;
import com.example.demo.service.store.StoreInfoService;


@Controller
public class BranchController {
	
	@Autowired
	StoreInfoService storeInfoService;
	
	@GetMapping("/manage_branch")
	public ModelAndView manage_branch(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<StoreInfo> storeList = storeInfoService.getStoreList();
		
		mav.addObject("storeList",storeList);
		mav.setViewName("branch/manage_branch");

		return mav;
	}
}
