package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Prod;
import com.example.demo.model.Staff;
import com.example.demo.service.Prod.ProdService;


@Controller
public class ProdController {
	
	@Autowired
	ProdService prodSerive;
	
	@GetMapping("/prod_Info")
	public ModelAndView prod_Info(ModelAndView mav) {

		
		//접속 id 불러오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName();
		
		
		List<Prod> prodList = prodSerive.getProdList();
		
		mav.addObject("prodList",prodList);
		
		mav.setViewName("prod/prod_Info");
		
        /*
		mav.addObject("id", id);
		mav.addObject("staffList",staffList);
		mav.setViewName("manage_employee");
		*/
		return mav;
	}
}
