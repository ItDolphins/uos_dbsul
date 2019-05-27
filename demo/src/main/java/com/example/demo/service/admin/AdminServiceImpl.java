package com.example.demo.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.admin.AdminDao;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	@Override
	public List<String> getAdminName() {
		List<String> nameList = adminDao.adminNameList();
		return nameList;
	}

	@Override
	public boolean checkByAdminNo(String admin_no) {
		return adminDao.findByAdminNo(admin_no).isPresent();
	}

}
