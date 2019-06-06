package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Calc {

	private  int store_no;
	private Date calc_yrmn;
	private int maint_amt;
	private int labor_amt;
	private int mon_sales_amt;
	private int head_charge;
}
