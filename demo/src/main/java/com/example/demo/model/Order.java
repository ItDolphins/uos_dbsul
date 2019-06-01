package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter @Setter
public class Order {

	private int order_no;
	private Date order_date;
	private int store_no;
	private  String order_state;
}
