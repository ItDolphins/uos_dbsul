package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

public class StoreInfo {
	@Getter @Setter
	private String store_no;
	@Getter @Setter
	private String store_name;
	@Getter @Setter
	private String store_code;
	@Getter @Setter
	private String store_pnum;
	@Getter @Setter
	private String admin_no;
	@Getter @Setter
	private String store_postno;
	
	@Getter @Setter
	private String admin_name;
	
	@Getter @Setter
	private String store_addr;
}
