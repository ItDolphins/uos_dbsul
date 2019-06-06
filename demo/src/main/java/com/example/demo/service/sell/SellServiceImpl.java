package com.example.demo.service.sell;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Sell;
import com.example.demo.repository.sell.SellDao;

@Transactional
@Service
public class SellServiceImpl implements SellService{

	@Autowired
	SellDao sellDao;
	
	@Override
	public void insertSell(Sell sell) {
		sellDao.insertSell(sell);
	}

	@Override
	public List<Sell> getSellList(int store_no) {
		List<Sell> sellList = sellDao.getSellList(store_no);
		return sellList;
	}
	
}
