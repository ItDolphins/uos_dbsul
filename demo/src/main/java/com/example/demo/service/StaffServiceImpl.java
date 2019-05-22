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
	public List<Staff> getStaffList(String id) {
		List<Staff> staff = staffDao.findbyAcnt_id(id);
		return staff;
	}
	
	@Override
	public Staff getStaffInfo(String staff_no) {
		Staff staff = staffDao.findbyStaff_no(staff_no);
		return staff;
	}
	
	@Override
	public void updateStaffInfo(String staff_no, String staff_name, String staff_pos, String resign_flag, String staff_acntno,String staff_pnum, String staff_acntbank) {
		staffDao.updateStaffInfo(staff_no, staff_name, staff_pos, resign_flag, staff_acntno, staff_pnum, staff_acntbank);
	}

	@Override
	public void insertStaffInfo(String staff_name, String staff_pos, String store_no, String resign_flag,
			String staff_acntno, String staff_pnum, String staff_acntbank) {
		staffDao.insertStaffInfo(staff_name, staff_pos, store_no, resign_flag, staff_acntno, staff_pnum, staff_acntbank);		
	}

}
