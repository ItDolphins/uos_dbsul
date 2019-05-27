package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter @Setter
public class Order {

	private String order_no;
	private Date order_date;
	private String store_no;
	private  String order_state;
}
