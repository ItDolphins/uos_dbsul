package com.example.demo.service.busireq;


import com.example.demo.model.Busireq;
import com.example.demo.repository.Busireq.BusireqDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BusireqService {

	@Autowired
	BusireqDao busireqDao;

	public Busireq getBusireq(int req_no){
		Busireq busireq = busireqDao.findByReq_no(req_no);
		return busireq;
	}

	public List<Busireq> getBusireqList(int order_no){
		List<Busireq> busireqList = busireqDao.findByOrder_no(order_no);
		return busireqList;
	}

	public  boolean isAllDeliv_state(int order_no, String deliv_state){
		if(busireqDao.findByOrder_noAndNotDeliv_state(order_no, deliv_state).size() == 0)
			return true;
		else
			return  false;
	}

	public void insertBusireq(Busireq busireq){
		busireqDao.insertBusireq(busireq);
	}

	public void updateBusireq(Busireq busireq){
		busireqDao.updateBusireq(busireq);
	}
}
