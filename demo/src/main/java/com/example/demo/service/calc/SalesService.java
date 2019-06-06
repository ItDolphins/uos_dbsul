package com.example.demo.service.calc;

import com.example.demo.model.Sales;
import com.example.demo.repository.calc.SalesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @Transactional
public class SalesService {

	@Autowired
	SalesDao salesDao;


	public List<Sales> getSalesList(int store_no){
		List<Sales> salesList = salesDao.findByStore_no(store_no);
		return  salesList;
	}

}
