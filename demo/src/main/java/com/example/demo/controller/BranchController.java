package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Account;
import com.example.demo.model.Prod;
import com.example.demo.model.Staff;
import com.example.demo.model.StoreInfo;
import com.example.demo.model.Work;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.prod.ProdService;
import com.example.demo.service.store.StoreInfoService;


@Controller
public class BranchController {
	
	@Autowired
	StoreInfoService storeInfoService;
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/manage_branch")
	public ModelAndView manage_branch(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<StoreInfo> storeList = storeInfoService.getStoreList();
		
		mav.addObject("storeList",storeList);
		mav.setViewName("branch/manage_branch");

		return mav;
	}
	
	@GetMapping("/add_branch_form")
	public ModelAndView add_employee_form(ModelAndView mav) {
		mav.setViewName("branch/add_branch_form");
		return mav;
	}
	
	@RequestMapping("/add_branch_process")
	public String process_add_branch(@ModelAttribute("store") StoreInfo store) {
		if(!adminService.checkByAdminNo(store.getAdmin_no())) 
			return "error/admin_no_error";
		
		storeInfoService.insertStoreInfo(store);
		return "redirect:/manage_branch";
	}
}
