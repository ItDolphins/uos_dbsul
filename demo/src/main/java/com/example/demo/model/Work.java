package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter @Setter
public class Work {
	private int staff_no;
	private int work_no;
	private Date work_start_time;
	private Date work_end_time;
}