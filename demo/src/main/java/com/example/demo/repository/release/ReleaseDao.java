package com.example.demo.repository.release;

import java.util.List;

import com.example.demo.model.Stock;

public interface ReleaseDao {
	List<Stock> getStockList(int acnt_store_no);
}
