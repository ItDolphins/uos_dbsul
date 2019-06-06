package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Event;
import com.example.demo.model.Prod;
import com.example.demo.service.event.EventService;

@Controller
public class EventController {

	@Autowired
	EventService eventService;
	
	@GetMapping("/event_Info")
	public ModelAndView event_Info(ModelAndView mav) {
		List<Event> eventDcList = eventService.getNowDcEventList();
		List<Event> eventPrList = eventService.getNowPrEventList();
		mav.addObject("eventDcList",eventDcList);
		mav.addObject("eventPrList",eventPrList);
		
		mav.setViewName("event/event_Info");
		
		return mav;
		
	}
	
	
	@GetMapping("/event_manage")
	public ModelAndView event_Manage(ModelAndView mav) {
		List<Event> eventDcList = eventService.getDcEventList();
		List<Event> eventPrList = eventService.getPrEventList();
		mav.addObject("eventDcList",eventDcList);
		mav.addObject("eventPrList",eventPrList);
		
		mav.setViewName("event/event_manage");
		
		return mav;
		
	}
	
	
	
	@GetMapping("/pr_event_add_form")
	public ModelAndView prAddForm(ModelAndView mav) {

		mav.setViewName("event/add_pr_event_form");
		
		return mav;
		
	}
	@GetMapping("/dc_event_add_form")
	public ModelAndView dcAddForm(ModelAndView mav) {

		mav.setViewName("event/add_dc_event_form");
		
		return mav;
		
	}
	
	@PostMapping("/add_pr_event")
	public String add_pr_event(@ModelAttribute("event") Event event) {

		eventService.insertPrEvent(event);
		
		return "redirect:/event_manage";
	}
	
	@PostMapping("/add_dc_event")
	public String add_dc_event(@ModelAttribute("event") Event event) {

		eventService.insertDcEvent(event);
		
		return "redirect:/event_manage";
	}
	
	
}
