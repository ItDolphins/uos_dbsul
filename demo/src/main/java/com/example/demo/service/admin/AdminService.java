package com.example.demo.service.admin;

import java.util.List;

import com.example.demo.model.Admin;

public interface AdminService {
	List<String> getAdminName();
	boolean checkByAdminNo(String admin_no);
	List<Admin> getAdminList();
	void insertAdmin(Admin admin);
	Admin getByAdminNo(String adminNo);
	void alterAdminInfo(Admin admin);
}
