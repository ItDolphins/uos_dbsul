package com.example.demo.service.prod;

import java.util.ArrayList;

import com.example.demo.model.Prod;

public interface ProdService {
	ArrayList<Prod> getProdList();
	void insertProd(Prod prod);
	void alterProd(Prod prod);
	Prod getProdbyNo(String prod_no);
}
