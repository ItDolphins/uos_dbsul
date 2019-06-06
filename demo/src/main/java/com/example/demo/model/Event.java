package com.example.demo.model;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Event {
	private int present_no;
	
	private int dc_no;
	
	private String event_prod;
	
	private int event_prod_no;
	
	private String event_name;
	
	private Date event_start_day;
	
	private Date event_end_day;
	
	private String present_prod;
	
	private int present_prod_no;
	
	private int dc_rate;
	
}
