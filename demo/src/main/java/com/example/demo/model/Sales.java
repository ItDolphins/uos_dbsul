package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Sales {
	private int store_no;
	private Date sales_date;
	private int sales_amt;
}
