package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController2 {
	
	@GetMapping("/")
	public String main_page() {
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//System.out.println(auth.isAuthenticated());
		//System.out.println("테스트 중");
		//System.out.println(auth.getPrincipal());
		//System.out.println(auth.getName());
		return "index";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	/*
	@GetMapping("/")
	public String f() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getAuthorities());
		return "";
	}*/
}
