package com.example.demo.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Stock {
	private List<Stock> stockList;
	private int prod_no;
	private Date expdate;
	private int store_no;
	private int stock_qnt;
	private String prod_name;
}
