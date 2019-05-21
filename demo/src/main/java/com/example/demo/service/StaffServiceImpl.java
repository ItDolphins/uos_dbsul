package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Staff;
import com.example.demo.repository.StaffDao;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	StaffDao staffDao;
	
	@Override
	public List<Staff> getStaffList(String storeNo) {
		List<Staff> staff = staffDao.findByStoreNoa(storeNo);
		return staff;
	}

}
