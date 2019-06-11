package com.example.demo.service.stock;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.DiscountStock;
import com.example.demo.model.Stock;
import com.example.demo.repository.stock.StockDao;

@Transactional
@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockDao stockDao;
	
	@Override
	public List<Stock> getStockList(int acnt_store_no) {
		List<Stock> stockList = stockDao.getStockList(acnt_store_no);
		return stockList;
	}

	@Override
	public Stock getStock(int prod_no, Date expdate, int store_no) {
		Stock stock = stockDao.getStock(prod_no, expdate, store_no);
		return stock;
	}

	@Override
	public  boolean isStockExist(int prod_no,Date expdate, int store_no){
		List<Stock> stockList= stockDao.findStock(prod_no, expdate, store_no);
		return stockList.size() != 0;

	}

	@Override
	public void updateStock(Stock stock, int changed_amount) {
		stockDao.updateStock(stock, changed_amount);
		
	}

	@Override
	public  void insertStock(Stock stock){
		stockDao.insertStock(stock);
	}
	@Override
	public  void deleteStock(Stock stock){
		stockDao.deleteStock(stock);
	}
	@Override
	public int getStock_qnt(int prod_no, Date expdate, int store_no) {
		int stock_qnt = stockDao.getStock_qnt(prod_no, expdate, store_no);
		return stock_qnt;
	}

	@Override
	public List<DiscountStock> getDiscountStockList(int acnt_store_no) {
		List<DiscountStock> stockList = stockDao.getDiscountStockList(acnt_store_no);
		return stockList;
	}

}