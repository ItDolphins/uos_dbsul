package com.example.demo.service.event;

import java.util.ArrayList;

import com.example.demo.model.Event;

public interface EventService {
	ArrayList<Event> getDcEventList();
	ArrayList<Event> getPrEventList();
	void insertPrEvent(Event event);
	void insertDcEvent(Event event);
}
