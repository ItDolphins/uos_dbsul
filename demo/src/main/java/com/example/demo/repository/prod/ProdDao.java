package com.example.demo.repository.prod;

import java.util.ArrayList;

import com.example.demo.model.Busi;
import com.example.demo.model.Prod;

public interface ProdDao {
	ArrayList<Prod> findAllProd();
	void insertProdToDB(Prod prod);
	Busi matchBusiName(String busi_name);
}
