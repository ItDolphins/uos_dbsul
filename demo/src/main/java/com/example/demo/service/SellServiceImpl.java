package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sell;
import com.example.demo.repository.SellRepository;

@Service
public class SellServiceImpl implements SellService {

	@Autowired
	private SellRepository sellRepository;
	
	@Override
	public Sell findById(int id) {
		return sellRepository.findSell(id);
	}
	
}
