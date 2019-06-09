package com.example.demo.repository.stock;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.DiscountStock;
import com.example.demo.model.Stock;

public interface StockDao {
	List<Stock> getStockList(int acnt_store_no);
	Stock getStock(int prod_no,Date expdate, int store_no);
	List<Stock> findStock(int prod_no,Date expdate, int store_no);
	void updateStock(Stock stock,int changed_amount);
	void insertStock(Stock stock);
	int getStock_qnt(int prod_no,Date expdate,int store_no);
	List<DiscountStock> getDiscountStockList(int acnt_store_no);
}