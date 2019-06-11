package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SellInfo {

	private int prod_no;
	private Date expdate;
	private int amount;
}
