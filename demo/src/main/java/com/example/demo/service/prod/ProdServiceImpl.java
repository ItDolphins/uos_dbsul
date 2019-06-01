package com.example.demo.service.prod;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Busi;
import com.example.demo.model.Prod;
import com.example.demo.repository.prod.ProdDao;

@Transactional
@Service
public class ProdServiceImpl implements ProdService {
	
	@Autowired
	ProdDao prodDao;
	
	@Override
	public ArrayList<Prod> getProdList() {
		ArrayList<Prod> prod = prodDao.findAllProd();
		return prod;
	}

	@Override
	public void insertProd(Prod prod) {
		// TODO Auto-generated method stub
		String busi_name=prod.getBusi_name();
		Busi busi=null;
		busi=prodDao.matchBusiName(busi_name);
		prod.setBusi_no(busi.getBusi_no());
		prodDao.insertProdToDB(prod);
	}

	@Override
	public boolean checkByProdNo(int prod_no) {
		return prodDao.findByProdNo(prod_no).isPresent();
	}

	@Override
	public String getNameByProdNo(int prod_no) {
		String result = prodDao.getNameByProdNo(prod_no);
		return result;
	}

	
}
