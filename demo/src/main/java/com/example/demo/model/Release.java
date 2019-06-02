package com.example.demo.model;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Release {
	private int rls_no;
	private int store_no;
	private String rls_code;
	private Timestamp rls_date;
	private int prod_no;
	private Date expdate;
	private String prod_name;
	private int rls_qnt;
}
