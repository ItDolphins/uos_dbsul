package com.example.demo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter @Setter @NoArgsConstructor
public class Order {

	private int order_no;
	private Date order_date;
	private int store_no;
	private  String order_state;

	public Order(int store_no){
		this.order_date = new Date();
		this.store_no = store_no;
		this.order_state = "발주생성중";
	}
}
