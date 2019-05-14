package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.SellService;

@Controller
public class TestController2 {
	
	@Autowired
	private SellService sellService;

	/*@GetMapping("/test2")
	public String get() {
		return "hello";
	}
	
	@GetMapping("/test3")
	public String get2(Model model) {
		model.addAttribute("name", "mye");
		return "hello2";
	}*/
	@GetMapping("/index")
	public String get3() {
		return "index";
	}
	
	@GetMapping("/index2")
	public String get4() {
		return "index2";
	}
	/*
	@GetMapping("/")
	public String f() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getAuthorities());
		return "";
	}*/
}
