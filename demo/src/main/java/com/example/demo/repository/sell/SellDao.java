package com.example.demo.repository.sell;

import java.util.List;

import com.example.demo.model.Sell;

public interface SellDao {
	void insertSell(Sell sell);
	List<Sell> getSellList();
}
