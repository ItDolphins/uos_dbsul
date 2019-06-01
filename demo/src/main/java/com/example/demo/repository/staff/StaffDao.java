package com.example.demo.repository.staff;

import java.util.List;

import com.example.demo.model.Staff;

public interface StaffDao {
	List<Staff> findByAcnt_store_no(int acnt_store_no);
	Staff getByStaff_no(int staff_no);
	void updateStaff(Staff staff);
	void insertStaff(Staff staff);
}
