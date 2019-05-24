package com.example.demo.controller;



import com.example.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.model.StoreInfo;

import com.example.demo.service.StoreInfoService;

@Controller
public class MainController {


	@Autowired
	StoreInfoService storeInfoService;


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/home")
	public ModelAndView template(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		StoreInfo storeInfo = storeInfoService.getStoreInfo(account.getStore_no());


		mav.addObject("storeInfo", storeInfo);
		mav.addObject("acnt_id", account.getUsername());
		mav.setViewName("home");
		return mav;
	}

	@GetMapping("/")
	public String f() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getAuthorities());
		return "redirect:/home";
	}
}
