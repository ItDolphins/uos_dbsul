package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Staff;
import com.example.demo.model.StoreInfo;
import com.example.demo.service.StaffService;
import com.example.demo.service.StoreInfoService;

@Controller
public class MainController {


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
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		StoreInfo storeInfo = storeInfoService.getStoreInfo(account.getAcnt_store_no());


		mav.addObject("storeInfo", storeInfo);
		mav.addObject("acnt_id", account.getUsername());
		mav.setViewName("home");
		return mav;
	}

	@GetMapping("/manage_employee")
	public ModelAndView manage_employee(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Staff> staffList = staffService.getStaffList(account.getAcnt_store_no());


		mav.addObject("acnt_id", account.getUsername());
		mav.addObject("staffList", staffList);
		mav.setViewName("manage_employee");

		return mav;
	}

	@GetMapping("/alter_employee")
	public ModelAndView alter_employee(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Staff> staffList = staffService.getStaffList(account.getAcnt_store_no());


		mav.addObject("acnt_id", account.getUsername());
		mav.addObject("staffList", staffList);
		mav.setViewName("alter_employee");
		return mav;
	}

	@GetMapping("/alter_employee_form")
	public ModelAndView alter_employee_form(ModelAndView mav, HttpServletRequest request) {

		String staff_no = request.getParameter("radio_button");

		Staff staff = staffService.getStaff(staff_no);

		mav.addObject("staff", staff);
		mav.setViewName("alter_employee_form");
		return mav;
	}

	@RequestMapping("/process_alter_employee")
	public String process_alter_employee(@ModelAttribute("staff") Staff staff) {

		staffService.updateStaff(staff);

		return "redirect:/alter_employee";
	}

	@GetMapping("/add_employee_form")
	public ModelAndView add_employee_form(ModelAndView mav) {
		mav.setViewName("add_employee_form");
		return mav;
	}

	@RequestMapping("/process_add_employee")
	public String process_add_employee(@ModelAttribute("staff") Staff staff) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		staff.setStore_no(account.getAcnt_store_no());
		staff.setResign_flag("N");

		staffService.insertStaff(staff);

		return "redirect:/manage_employee";
	}

	@GetMapping("/")
	public String f() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getAuthorities());
		return "redirect:/home";
	}
}
