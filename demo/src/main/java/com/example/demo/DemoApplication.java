package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.service.AccountService;
import com.example.demo.service.staff.StaffService;
import com.example.demo.service.store.StoreInfoService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	


	
	@Autowired
	AccountService accountService;
	
	@Autowired
	StoreInfoService storeInfoService;
	
	@Autowired
	StaffService staffService;
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(DemoApplication.class, args);

	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		
		//String id = "chiwon";
		//System.out.println(accountService.getPw(id));
		//StoreInfo s = new StoreInfo();
		//s = storeInfoService.getStoreInfo("chiwon");
		//System.out.println(s.getADMIN_NAME());

		//List<Staff> staffs = staffService.getStaffList("chiwon");
		
		//Staff s = staffs.get(0);
		//System.out.println(s.getStaff_name());
		
		//staffService.updateStaffInfo("1", "노치호", "점장", "N", "9904-5030-5452", "010-7697-8640", "우리");
		//Staff s = staffService.getStaffInfo("1");
		//System.out.println(s.getStaff_name());
	}

}
