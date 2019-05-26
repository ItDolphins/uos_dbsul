package com.example.demo.repository.prod;

import java.util.ArrayList;

import com.example.demo.model.Prod;

public interface ProdDao {
	ArrayList<Prod> findAllProd();
	void insertProdToDB(Prod pord);
	Prod matchBusiName(String busi_no);
}
