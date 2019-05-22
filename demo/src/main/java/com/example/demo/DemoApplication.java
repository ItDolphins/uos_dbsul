package com.example.demo;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Staff;
import com.example.demo.model.StoreInfo;
import com.example.demo.service.AccountService;
import com.example.demo.service.StaffService;
import com.example.demo.service.StoreInfoService;
//import org.springframework.security.core.userdetails.UserDetails;

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

		List<Staff> staffs = staffService.getStaffList("chiwon");
		
		Staff s = staffs.get(0);
		System.out.println(s.getStaff_name());
		
	}

}
