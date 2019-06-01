package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Getter @Setter
public class Work {
	private int staff_no;
	private Timestamp work_start_time;
	private Timestamp work_end_time;
}
