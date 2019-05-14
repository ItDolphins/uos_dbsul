package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sell;

@Repository
public class SellRepositoryImpl implements SellRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Sell findSell(int id) {
		return new Sell();
	}
	
}
