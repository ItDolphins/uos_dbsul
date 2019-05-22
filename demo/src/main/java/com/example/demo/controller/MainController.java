package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		//접속 id 불러오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName();
		
		StoreInfo storeInfo = storeInfoService.getStoreInfo(id);


        mav.addObject("storeInfo",storeInfo);
        mav.addObject("id", id);
		mav.setViewName("home");
		return mav;
	}

	@GetMapping("/manage_employee")
	public ModelAndView manage_employee(ModelAndView mav) {
		//접속 id 불러오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName();
		
		List<Staff> staffList = staffService.getStaffList(id);
		
        
		mav.addObject("id", id);
		mav.addObject("staffList",staffList);
		mav.setViewName("manage_employee");
		
		return mav;
	}
	
	@GetMapping("/alter_employee")
	public ModelAndView alter_employee(ModelAndView mav) {
		//접속 id 불러오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName();
				
		List<Staff> staffList = staffService.getStaffList(id);
				
		        
		mav.addObject("id", id);
		mav.addObject("staffList",staffList);
		mav.setViewName("alter_employee");
		return mav;
	}
	
	@GetMapping("/alter_employee_form")
	public ModelAndView alter_employee_form(ModelAndView mav,HttpServletRequest request) {
		//접속 id 불러오는 방법
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String id = auth.getName();
				
		String staff_no = request.getParameter("radio_button");
		
		Staff staff = staffService.getStaffInfo(staff_no);
		
		mav.addObject("staff",staff);
		mav.setViewName("alter_employee_form");
		return mav;
	}
	
	@RequestMapping("/process_alter_employee")
	public String process_alter_employee(HttpServletRequest request) {
		String staff_name = request.getParameter("staff_name");
		String staff_pos = request.getParameter("staff_pos");
		String staff_acntno = request.getParameter("staff_acntno");
		String staff_acntbank = request.getParameter("staff_acntbank");
		String staff_pnum = request.getParameter("staff_pnum");
		String resign_flag = request.getParameter("resign_flag");
		String staff_no = request.getParameter("staff_no");
		
		staffService.updateStaffInfo(staff_no, staff_name, staff_pos, resign_flag, staff_acntno, staff_pnum, staff_acntbank);
		
		return "redirect:/alter_employee";
	}
	
	@GetMapping("/")
	public String f() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getAuthorities());
		return "redirect:/home";
	}
}
