package com.example.demo.controller;



import com.example.demo.model.Account;
import com.example.demo.model.Event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import com.example.demo.dto.StoreInfo;
import com.example.demo.service.event.EventService;
import com.example.demo.service.store.StoreInfoService;

@Controller
public class MainController {


	@Autowired
	StoreInfoService storeInfoService;
	@Autowired
	EventService eventService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/home")
	public ModelAndView template(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		StoreInfo storeInfo = storeInfoService.getStoreInfo(account.getStore_no());
		
		List<Event> eventDcList = eventService.getNowDcEventList();
		List<Event> eventPrList = eventService.getNowPrEventList();
		List<Event> eventList = new ArrayList<Event>();
		eventList.addAll(eventDcList);
		eventList.addAll(eventPrList);
		
		
		
		mav.addObject("eventList",eventList);

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