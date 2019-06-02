package com.example.demo.repository.prod;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.model.Busi;
import com.example.demo.model.Prod;

public interface ProdDao {
	ArrayList<Prod> findAllProd();
	void insertProdToDB(Prod prod);
	void alterProdToDB(Prod prod);
	Busi matchBusiName(String busi_name);
	Prod findProdByNo(String prod_no);
	Optional<String> findByProdNo(int prod_no);
	String getNameByProdNo(int prod_no);
}