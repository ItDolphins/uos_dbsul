package com.example.demo.controller;

import java.sql.Date;
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
import com.example.demo.model.Member;
import com.example.demo.service.member.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/manage_member")
	public ModelAndView manage_member(ModelAndView mav) {
		Account account = (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		List<Member> memberList = memberService.getMemberList();

		mav.addObject("memberList", memberList);
		mav.setViewName("member/manage_member");

		return mav;
	}
	
	@GetMapping("/add_member_form")
	public ModelAndView add_member_form(ModelAndView mav) {

		mav.setViewName("member/add_member_form");

		return mav;
	}
	
	@RequestMapping("/process_add_member")
	public String process_add_member(@ModelAttribute("member") Member member) {
		memberService.insertMember(member);
		
		return "redirect:/manage_member";
	}
	
	@GetMapping("/alter_member")
	public ModelAndView alter_member(ModelAndView mav) {
		List<Member> memberList = memberService.getMemberList();
		
		mav.addObject("memberList",memberList);
		mav.setViewName("member/alter_member");
		
		return mav;
	}
	
	@RequestMapping("/alter_member_form")
	public ModelAndView alter_member_form(ModelAndView mav, HttpServletRequest request) {
		int member_no = Integer.parseInt(request.getParameter("radio_button"));
		
		Member member = memberService.getByMemberNo(member_no);
		mav.addObject("member",member);
		mav.setViewName("member/alter_member_form");
		
		return mav;
	}
	
	@RequestMapping("/process_alter_member")
	public String process_alter_member(@ModelAttribute("member") Member member) {
		memberService.alterMemberInfo(member);
		
		return "redirect:/manage_member";
	}
}
