package com.example.demo.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Stock {
	private int prod_no;
	private Date expdate;
	private int store_no;
	private int stock_qnt;
	private String prod_name;
}
