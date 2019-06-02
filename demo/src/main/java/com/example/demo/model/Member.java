package com.example.demo.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
	private int member_no;
	private String member_gend;
	private Date member_birth;
	private String member_name;
	private Date member_reg_day;
	private int member_mileage;
	private String member_class;
}
