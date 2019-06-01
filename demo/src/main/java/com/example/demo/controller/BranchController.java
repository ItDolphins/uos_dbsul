package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		List<StoreInfo> storeList = storeInfoService.getStoreList();
		
		mav.addObject("storeList",storeList);
		mav.setViewName("branch/manage_branch");

		return mav;
	}
	
	@GetMapping("/add_branch_form")
	public ModelAndView add_branch_form(ModelAndView mav) {
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
	
	@GetMapping("/alter_branch")
	public ModelAndView alter_branch(ModelAndView mav) {
		
		List<StoreInfo> storeList = storeInfoService.getStoreList();
		
		mav.addObject("storeList",storeList);
		mav.setViewName("branch/alter_branch");
		return mav;
	}
	
	@RequestMapping("/alter_branch_form")
	public ModelAndView alter_branch_form(ModelAndView mav,HttpServletRequest request) {
		String store_no = request.getParameter("radio_button");
		StoreInfo store = storeInfoService.getStoreInfo(Integer.parseInt(store_no));
		mav.addObject("store",store);
		System.out.println(store.getStore_addr());
		if(store_no.equals("1"))
			mav.setViewName("branch/alter_headquarter_form");
		else
			mav.setViewName("branch/alter_branch_form");
		
		return mav;
	}
	
	@RequestMapping("/process_alter_branch")
	public String process_alter_branch(@ModelAttribute("StoreInfo") StoreInfo store) {
		if(!adminService.checkByAdminNo(store.getAdmin_no())) 
			return "error/admin_no_error";
		
		storeInfoService.updateStoreInfo(store);
		return "redirect:/manage_branch";
	}
}
