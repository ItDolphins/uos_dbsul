package com.example.demo.service.admin;

import java.util.List;

import com.example.demo.model.Admin;

public interface AdminService {
	List<String> getAdminName();
	boolean checkByAdminNo(int admin_no);
	List<Admin> getAdminList();
	void insertAdmin(Admin admin);
	Admin getByAdminNo(int adminNo);
	void alterAdminInfo(Admin admin);
}
