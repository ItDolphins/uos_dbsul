package com.example.demo.service.event;

import java.util.ArrayList;

import com.example.demo.model.Event;

public interface EventService {
	ArrayList<Event> getDcEventList();
	ArrayList<Event> getNowDcEventList();
	ArrayList<Event> getPrEventList();
	ArrayList<Event> getNowPrEventList();
	void insertPrEvent(Event event);
	void insertDcEvent(Event event);
	Event getEventByPresentNo(String present_no);
	Event getEventByDcNo(String dc_no);
	void updatePrEvent(Event event);
	void updateDcEvent(Event event);
}
