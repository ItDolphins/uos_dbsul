package com.example.demo.service.prod;

import java.util.ArrayList;

import com.example.demo.model.Prod;

public interface ProdService {
	ArrayList<Prod> getProdList();
	ArrayList<Prod> getProdListNow();
	void insertProd(Prod prod);
	void alterProd(Prod prod);
	Prod getProdbyNo(String prod_no);
	boolean checkByProdNo(int prod_no);
	String getNameByProdNo(int prod_no);
	int getPriceByProdNo(int prod_no);
	int getNoByProdName(String prod_name);
}
