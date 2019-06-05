package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Event;
import com.example.demo.service.event.EventService;

@Controller
public class EventController {

	@Autowired
	EventService eventService;
	
	@GetMapping("/event_Info")
	public ModelAndView event_Info(ModelAndView mav) {
		List<Event> eventList = eventService.getEventList();
		
		mav.addObject("eventList",eventList);
		
		mav.setViewName("event/event_Info");

		return mav;
		
	}
}
