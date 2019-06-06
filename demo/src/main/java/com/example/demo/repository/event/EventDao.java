package com.example.demo.repository.event;

import java.util.ArrayList;

import com.example.demo.model.Event;

public interface EventDao {

	ArrayList<Event> findAllPrEvent();
	ArrayList<Event> findNowPrEvent();
	ArrayList<Event> findAllDcEvent();
	ArrayList<Event> findNowDcEvent();
	void insertPrEvent(Event event);
	void insertDcEvent(Event event);
}
