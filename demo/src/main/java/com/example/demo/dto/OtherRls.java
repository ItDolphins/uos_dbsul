package com.example.demo.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OtherRls {
	private int prod_no;
	private String expdate;
	private int rls_qnt;
	private String rls_code;
}
