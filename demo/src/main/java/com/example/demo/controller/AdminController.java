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
import com.example.demo.model.Admin;
import com.example.demo.service.admin.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/manage_admin")
	public ModelAndView manage_branch(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Admin> adminList = adminService.getAdminList();
		mav.addObject("adminList",adminList);
		mav.setViewName("admin/manage_admin");

		return mav;
	}
	
	@GetMapping("/add_admin_form")
	public ModelAndView add_admin_form(ModelAndView mav) {
		mav.setViewName("admin/add_admin_form");
		return mav;
	}
	
	@RequestMapping("/add_admin_process")
	public String add_admin_process(@ModelAttribute("admin") Admin admin) {
		adminService.insertAdmin(admin);
		
		return "redirect:/manage_admin";
		
	}
	
	@GetMapping("/alter_admin")
	public ModelAndView alter_admin(ModelAndView mav) {
		List<Admin> adminList = adminService.getAdminList();
		
		mav.addObject("adminList",adminList);
		mav.setViewName("admin/alter_admin");
		return mav;
	}
	
	@RequestMapping("/alter_admin_form")
	public ModelAndView alter_admin_form(ModelAndView mav,HttpServletRequest request) {
		int admin_no = Integer.parseInt(request.getParameter("radio_button"));
		
		Admin admin = adminService.getByAdminNo(admin_no);
		mav.addObject("admin",admin);
		mav.setViewName("admin/alter_admin_form");
		
		return mav;
	}
	
	@RequestMapping("/process_alter_admin")
	public String process_alter_admin(@ModelAttribute("admin") Admin admin) {
		adminService.alterAdminInfo(admin);
		
		return "redirect:/manage_admin";
	}
}