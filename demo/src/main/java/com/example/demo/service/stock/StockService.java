package com.example.demo.service.stock;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.example.demo.model.Stock;

public interface StockService {
	List<Stock> getStockList(int acnt_store_no);
	Stock getStock(int prod_no,Date expdate, int store_no);
	boolean isStockExist(int prod_no,Date expdate, int store_no);
	void updateStock(Stock stock,int changed_amount);
	void insertStock(Stock stock);
	int getStock_qnt(int prod_no, Date expdate, int store_no);
}