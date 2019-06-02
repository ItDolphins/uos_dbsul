package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class StoreInfo {

	private int store_no;
	private String store_name;
	private String store_class;
	private String store_pnum;
	private int admin_no;
	private String store_postno;
	
	private String admin_name;
	
	private String store_addr;
}