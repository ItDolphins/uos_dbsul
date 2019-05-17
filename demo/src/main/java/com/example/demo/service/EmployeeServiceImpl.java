package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee emp) {
		// TODO Auto-generated method stub
		employeeDao.insertEmployee(emp);
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		// TODO Auto-generated method stub
		employeeDao.insertEmployees(employees);
	}

	@Override
	public void getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees = employeeDao.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}

	@Override
	public void getEmployeeById(String empid) {
		// TODO Auto-generated method stub
		Employee employee = employeeDao.getEmployeeById(empid);
		System.out.println(employee);
	}

	

}