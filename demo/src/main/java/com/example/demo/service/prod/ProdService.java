package com.example.demo.service.prod;

import java.util.ArrayList;

import com.example.demo.model.Prod;

public interface ProdService {
	ArrayList<Prod> getProdList();
	void insertProd(Prod prod);
	boolean checkByProdNo(int prod_no);
	String getNameByProdNo(int prod_no);
}
