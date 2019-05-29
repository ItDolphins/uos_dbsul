package com.example.demo.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Stock {
	private List<Stock> stockList;
	private String prod_no;
	private String expdate;
	private String store_no;
	private String stock_qnt;
	private String prod_name;
}
