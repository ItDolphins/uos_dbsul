package com.example.demo.service.release;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Stock;
import com.example.demo.repository.release.ReleaseDao;

@Transactional
@Service
public class ReleaseServiceImpl implements ReleaseService{
	
	@Autowired
	ReleaseDao releaseDao;
	
	@Override
	public List<Stock> getStockList(String acnt_store_no) {
		List<Stock> stockList = releaseDao.getStockList(acnt_store_no);
		return stockList;
	}

}
