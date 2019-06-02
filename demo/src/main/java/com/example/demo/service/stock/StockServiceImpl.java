package com.example.demo.service.stock;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Stock;
import com.example.demo.repository.stock.StockDao;

@Transactional
@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockDao releaseDao;
	
	@Override
	public List<Stock> getStockList(int acnt_store_no) {
		List<Stock> stockList = releaseDao.getStockList(acnt_store_no);
		return stockList;
	}

	@Override
	public Stock getStock(int prod_no, Date expdate, int store_no) {
		Stock stock = releaseDao.getStock(prod_no, expdate, store_no);
		return stock;
	}

	@Override
	public void updateStock(Stock stock, int changed_amount) {
		releaseDao.updateStock(stock, changed_amount);
		
	}

}