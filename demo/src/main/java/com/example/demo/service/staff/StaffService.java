package com.example.demo.service.staff;

import java.util.List;

import com.example.demo.model.Staff;

public interface StaffService {
	List<Staff> getStaffList(int acnt_store_no);
	Staff getStaff(int staff_no);
	void updateStaff(Staff staff);
	void insertStaff(Staff staff);
}