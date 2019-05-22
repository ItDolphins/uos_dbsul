package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Staff;

public interface StaffDao {
	List<Staff> findbyAcnt_id(String id);
	Staff findbyStaff_no(String staff_no);
	void updateStaffInfo(String staff_no,String staff_name,String staff_pos,String resign_flag,String staff_acntno,String staff_pnum,String staff_acntbank);
}
