package com.example.demo.service.prod;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Busi;
import com.example.demo.model.Prod;
import com.example.demo.repository.prod.ProdDao;

@Service @Transactional
public class ProdServiceImpl implements ProdService {
	
	@Autowired
	ProdDao prodDao;
	
	@Override
	public ArrayList<Prod> getProdList() {
		ArrayList<Prod> prod = prodDao.findAllProd();
		return prod;
	}
	
	public ArrayList<Prod> getProdListNow() {
		ArrayList<Prod> prod = prodDao.findAllProdNow();
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
	public Prod getProdbyNo(String prod_no) {
		// TODO Auto-generated method stub
		Prod prod=prodDao.findProdByNo(prod_no);
		return prod;
	}

	@Override
	public void alterProd(Prod prod) {
		// TODO Auto-generated method stub
		String busi_name=prod.getBusi_name();
		Busi busi=null;
		busi=prodDao.matchBusiName(busi_name);
		prod.setBusi_no(busi.getBusi_no());
		prodDao.alterProdToDB(prod);
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

	@Override
	public int getPriceByProdNo(int prod_no) {
		int price = prodDao.getPriceByProdNo(prod_no);
		return price;
	}

	@Override
	public int getNoByProdName(String prod_name) {
		// TODO Auto-generated method stub
		int prod_no=prodDao.findNoByProdName(prod_name);
		return prod_no;
	}

	
}
