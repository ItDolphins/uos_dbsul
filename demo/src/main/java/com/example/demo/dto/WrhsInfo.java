package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class WrhsInfo {

	private  int wrhs_no;
	private  int req_no;
	private int order_no;
	private Date wrhs_date;
	private Date expdate;
	private int prod_no;
	private String prod_name;
	private int req_qnt;
	private int store_no;

}
