package com.example.demo.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Stock {
	private int prod_no;
	private Date expdate;
	private int store_no;
	private int stock_qnt;
	private String prod_name;

	public Stock(int prod_no, Date expdate, int store_no, int stock_qnt){
		this.setProd_no(prod_no);
		this.setStock_qnt(stock_qnt);
		this.setExpdate(expdate);
		this.setStore_no(store_no);
	}
}