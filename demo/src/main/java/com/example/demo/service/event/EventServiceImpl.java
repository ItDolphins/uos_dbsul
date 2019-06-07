package com.example.demo.service.event;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Event;
import com.example.demo.repository.event.EventDao;
import com.example.demo.repository.prod.ProdDao;
import com.example.demo.service.prod.ProdService;

@Service @Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao eventDao;
	@Autowired
	ProdService prodService;
	@Autowired
	ProdDao prodDao;
	
	@Override
	public ArrayList<Event> getDcEventList() {
		// TODO Auto-generated method stub
		ArrayList<Event> event=eventDao.findAllDcEvent();
		
		return event;
	}
	
	@Override
	public ArrayList<Event> getNowDcEventList() {
		// TODO Auto-generated method stub
		ArrayList<Event> event=eventDao.findNowDcEvent();
		
		return event;
	}
	
	@Override
	public ArrayList<Event> getPrEventList() {
		// TODO Auto-generated method stub
		ArrayList<Event> event=eventDao.findAllPrEvent();
		
		return event;
	}
	
	@Override
	public ArrayList<Event> getNowPrEventList() {
		// TODO Auto-generated method stub
		ArrayList<Event> event=eventDao.findNowPrEvent();
		
		return event;
	}
	
	@Override
	public void insertPrEvent(Event event) {
		// TODO Auto-generated method stub
		event.setEvent_prod_no(prodService.getNoByProdName(event.getEvent_prod()));
		event.setPresent_prod_no(prodService.getNoByProdName(event.getPresent_prod()));
		eventDao.insertPrEvent(event);
		
		
	}

	@Override
	public void insertDcEvent(Event event) {
		// TODO Auto-generated method stub
		event.setEvent_prod_no(prodService.getNoByProdName(event.getEvent_prod()));
		eventDao.insertDcEvent(event);
		
	}

	@Override
	public Event getEventByPresentNo(String present_no) {
		// TODO Auto-generated method stub
		Event event=eventDao.getEventByPresentNo(present_no);
		return event;
	}

	@Override
	public Event getEventByDcNo(String dc_no) {
		// TODO Auto-generated method stub
		Event event=eventDao.getEventByDcNo(dc_no);
		return event;
	}

	@Override
	public void updatePrEvent(Event event) {
		// TODO Auto-generated method stub
		event.setEvent_prod_no(prodService.getNoByProdName(event.getEvent_prod()));  
		event.setPresent_prod_no(prodService.getNoByProdName(event.getPresent_prod()));  
		eventDao.updatePrEvent(event);
	}

	@Override
	public void updateDcEvent(Event event) {
		// TODO Auto-generated method stub
		event.setEvent_prod_no(prodService.getNoByProdName(event.getEvent_prod()));  
		eventDao.updateDcEvent(event);
	}
}
