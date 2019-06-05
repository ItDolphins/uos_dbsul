package com.example.demo.service.busireq;


import com.example.demo.model.Wrhs;
import com.example.demo.repository.Busireq.WrhsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class WrhsService {

	@Autowired
	WrhsDao wrhsDao;

	public void insertWrhs(Wrhs wrhs){
		wrhsDao.insertWrhs(wrhs);
	}
}
