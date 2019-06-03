package com.example.demo.repository.stock;

import java.sql.Date;
import java.util.List;

import com.example.demo.model.Stock;

public interface StockDao {
	List<Stock> getStockList(int acnt_store_no);
	Stock getStock(int prod_no,Date expdate, int store_no);
	void updateStock(Stock stock,int changed_amount);
	int getStock_qnt(int prod_no,Date expdate,int store_no);
}