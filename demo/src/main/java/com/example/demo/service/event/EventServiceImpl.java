package com.example.demo.service.event;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Event;

@Service @Transactional
public class EventServiceImpl implements EventService {

	@Override
	public ArrayList<Event> getEventList() {
		// TODO Auto-generated method stub
		return null;
	}

}
