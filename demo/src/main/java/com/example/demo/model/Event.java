package com.example.demo.model;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Event {
	private int present_no;
	
	private int dc_no;
	
	private int event_prod;
	
	private String event_name;
	
	private Date event_start_day;
	
	private Date event_end_day;
	
	private int present_prod;
	
	private int dc_rate;
	
}
