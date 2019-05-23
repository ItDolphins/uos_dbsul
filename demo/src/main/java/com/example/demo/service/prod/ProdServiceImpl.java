package com.example.demo.service.prod;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Prod;
import com.example.demo.repository.prod.ProdDao;

@Service
public class ProdServiceImpl implements ProdService {
	
	@Autowired
	ProdDao prodDao;
	
	@Override
	public ArrayList<Prod> getProdList() {
		ArrayList<Prod> prod = prodDao.findAllProd();
		return prod;
	}

	
}
