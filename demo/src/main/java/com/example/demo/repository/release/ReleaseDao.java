package com.example.demo.repository.release;

import java.util.List;

import com.example.demo.model.Stock;

public interface ReleaseDao {
	List<Stock> getStockList(String acnt_store_no);
}
