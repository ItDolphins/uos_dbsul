package com.example.demo.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class WorkSum {
	private Date yearMonth;
	private int staff_no;
	private int worktimeSum;
	private int dayWorktimeSum;
	private int nightWorktimeSum;
	private int daySalarySum;
	private int nightSalarySum;
	private int salarySum;
}
