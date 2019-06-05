package com.example.demo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class Wrhs {

	private  int wrhs_no;
	private  int req_no;
	private Date wrhs_date;
	private Date expdate;

	public Wrhs(int req_no){

		this.req_no = req_no;
		this.wrhs_date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH, 2);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);

		this.expdate = new Date(cal.getTimeInMillis());
	}

}
