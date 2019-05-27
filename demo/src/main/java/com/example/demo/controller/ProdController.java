package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Prod;

import com.example.demo.service.prod.ProdService;


@Controller
public class ProdController {
	
	@Autowired
	ProdService prodService;
	
	@GetMapping("/prod_Info")
	public ModelAndView prod_Info(ModelAndView mav) {
		List<Prod> prodList = prodService.getProdList();
		
		mav.addObject("prodList",prodList);
		
		mav.setViewName("prod/prod_Info");

		return mav;
		
	}
	@GetMapping("/prod_manage")
	public ModelAndView prod_manage(ModelAndView mav) {
		List<Prod> prodList = prodService.getProdList();
		
		mav.addObject("prodList",prodList);
		
		mav.setViewName("prod/prod_manage");

		return mav;
	}
	
	@GetMapping("/add_prod_form")
	public ModelAndView add_employee_form(ModelAndView mav) {
		mav.setViewName("prod/add_prod_form");
		return mav;
	}
	
	@PostMapping("/add_prod")
	public String add_prod(@ModelAttribute("prod") Prod prod) {

		prodService.insertProd(prod);
		
		return "redirect:/prod_manage";
	}
}
