package com.example.demo.service.staff;

import java.util.List;

import com.example.demo.model.Staff;

public interface StaffService {
	List<Staff> getStaffList(String acnt_store_no);
	Staff getStaff(String staff_no);
	void updateStaff(Staff staff);
	void insertStaff(Staff staff);
}
