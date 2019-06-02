package com.example.demo.service.sell;

import java.util.List;

import com.example.demo.model.Sell;

public interface SellService {
	void insertSell(Sell sell);
	List<Sell> getSellList();
}
