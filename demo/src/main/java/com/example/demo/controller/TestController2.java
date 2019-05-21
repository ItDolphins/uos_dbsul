package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Staff;
import com.example.demo.model.StoreInfo;
import com.example.demo.service.StaffService;
import com.example.demo.service.StoreInfoService;

@Controller
public class TestController2 {
	
		
	@Autowired
	StoreInfoService storeInfoService;
	
	@Autowired
	StaffService staffService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/home")
	public ModelAndView template(ModelAndView mav) {
		//접속 id 불러오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName();
		
		StoreInfo storeInfo = storeInfoService.getStoreInfo(id);
		String admin_name = storeInfo.getADMIN_NAME();
		String store_no = storeInfo.getSTORE_NO();
		String store_name = storeInfo.getSTORE_NAME();
		String store_addr = storeInfo.getSTORE_ADDR();
		String store_pnum = storeInfo.getSTORE_PNUM();
		String store_postno = storeInfo.getSTORE_POSTNO();
		
		mav.addObject("id", id);
		mav.addObject("admin_name",admin_name);
		mav.addObject("store_no",store_no);
		mav.addObject("store_name",store_name);
		mav.addObject("store_addr",store_addr);
		mav.addObject("store_pnum",store_pnum);
		mav.addObject("store_postno",store_postno);
		mav.setViewName("home");
		return mav;
	}
	
	@GetMapping("/manage_employee")
	public ModelAndView manage_employee(ModelAndView mav) {
		//접속 id 불러오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName();
		
		List<Staff> staff = staffService.getStaff("1");
		for(int i=0; i<4; i++)
		{
			Staff s = staff.get(0);
			System.out.println(s.getStaff_no());
		}
		mav.addObject("id", id);
		mav.addObject("staff",staff);
		mav.setViewName("manage_employee");
		
		return mav;
	}
	
	
	/*
	@GetMapping("/")
	public String f() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getAuthorities());
		return "";
	}*/
}
