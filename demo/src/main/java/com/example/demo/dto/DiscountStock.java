package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
public class DiscountStock {
		private int prod_no;
		private Date expdate;
		private int store_no;
		private int stock_qnt;
		private String prod_name;
		private int prod_price;
		private int dc_rate;
}
