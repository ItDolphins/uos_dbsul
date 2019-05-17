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

import com.example.demo.model.Employee;
import com.example.demo.service.AccountService;
import com.example.demo.service.EmployeeService;
//import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	AccountService accountService;
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(DemoApplication.class, args);
		
		Employee emp= new Employee();
		emp.setEmpId("emp");
		emp.setEmpName("emp");
		
		Employee emp1= new Employee();
		emp1.setEmpId("emp1");
		emp1.setEmpName("emp1");
		
		Employee emp2= new Employee();
		emp2.setEmpId("emp2");
		emp2.setEmpName("emp2");

	}
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		/*Employee emp= new Employee();
		emp.setEmpId("emp");
		emp.setEmpName("emp");
		
		employeeService.insertEmployee(emp);
		employeeService.getEmployeeById("emp");*/
		
		//String id = "chiwon";
		//System.out.println(accountService.getPw(id));
	}

}
