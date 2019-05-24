package com.example.demo.controller;


import java.util.List;


import javax.servlet.http.HttpServletRequest;


import com.example.demo.model.Account;
import com.example.demo.model.Work;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Staff;

import com.example.demo.service.staff.StaffService;
import com.example.demo.service.staff.WorkService;


@Controller
public class StaffController {

	@Autowired
	StaffService staffService;
	@Autowired
	WorkService workService;


	@GetMapping("/manage_employee")
	public ModelAndView manage_employee(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Staff> staffList = staffService.getStaffList(account.getStore_no());

		mav.addObject("staffList", staffList);
		mav.setViewName("staff/manage_employee");

		return mav;
	}

	@GetMapping("/alter_employee")
	public ModelAndView alter_employee(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Staff> staffList = staffService.getStaffList(account.getStore_no());

		mav.addObject("staffList", staffList);
		mav.setViewName("staff/alter_employee");
		return mav;
	}

	@GetMapping("/alter_employee_form")
	public ModelAndView alter_employee_form(ModelAndView mav, HttpServletRequest request) {

		String staff_no = request.getParameter("radio_button");

		Staff staff = staffService.getStaff(staff_no);

		mav.addObject("staff", staff);
		mav.setViewName("staff/alter_employee_form");
		return mav;
	}

	@RequestMapping("/process_alter_employee")
	public String process_alter_employee(@ModelAttribute("staff") Staff staff) {

		staffService.updateStaff(staff);

		return "redirect:/alter_employee";
	}

	@GetMapping("/add_employee_form")
	public ModelAndView add_employee_form(ModelAndView mav) {
		mav.setViewName("staff/add_employee_form");
		return mav;
	}

	@RequestMapping("/process_add_employee")
	public String process_add_employee(@ModelAttribute("staff") Staff staff) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		staff.setStore_no(account.getStore_no());
		staff.setResign_flag("N");

		staffService.insertStaff(staff);

		return "redirect:/manage_employee";
	}

	@RequestMapping("/manage_work")
	public ModelAndView manage_work(ModelAndView mav, HttpServletRequest request) {

		String staff_no = request.getParameter("staff");

		Staff staff = staffService.getStaff(staff_no);
		List<Work> workList = workService.getWorkList(staff_no);

		mav.addObject("staff", staff);
		mav.addObject("workList", workList);
		mav.setViewName("staff/manage_work");
		return mav;
	}
}


