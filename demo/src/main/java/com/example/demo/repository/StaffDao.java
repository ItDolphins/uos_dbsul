package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Staff;

public interface StaffDao {
	List<Staff> findByAcnt_store_no(String acnt_store_no);
	Staff getByStaff_no(String staff_no);
	void updateStaff(Staff staff);
	void insertStaff(Staff staff);
}
