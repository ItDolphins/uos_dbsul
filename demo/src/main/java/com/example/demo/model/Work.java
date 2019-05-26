package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter @Setter
public class Work {
	private String staff_no;
	private String work_no;
	private Timestamp work_start_time;
	private Timestamp work_end_time;
}
