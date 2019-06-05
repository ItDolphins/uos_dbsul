package com.example.demo.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Date;

@Getter @Setter
public class Busireq {

	private int req_no;
	private int order_no;
	private String busi_conf_flag;
	private Date order_date;
	private String deliv_state;
	private Date deliv_date;
	private int prod_no;
	private int req_qnt;

	public Busireq(){
		this.setBusi_conf_flag("N");
		this.setDeliv_state("배송요청전");
	}
}
