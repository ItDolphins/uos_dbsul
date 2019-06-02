package com.example.demo.service.staff;

import java.util.List;

import com.example.demo.service.staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Staff;
import com.example.demo.repository.staff.StaffDao;

@Transactional
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffDao staffDao;
	
	@Override
	public List<Staff> getStaffList(int acnt_store_no) {
		List<Staff> staff = staffDao.findByAcnt_store_no(acnt_store_no);
		return staff;
	}
	
	@Override
	public Staff getStaff(int staff_no) {
		Staff staff = staffDao.getByStaff_no(staff_no);
		return staff;
	}
	
	@Override
	public void updateStaff(Staff staff) {
		staffDao.updateStaff(staff);
	}

	@Override
	public void insertStaff(Staff staff) {
		staffDao.insertStaff(staff);
	}

}