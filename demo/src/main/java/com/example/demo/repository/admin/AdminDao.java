package com.example.demo.repository.admin;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Admin;

public interface AdminDao {
	List<String> adminNameList();
	String getByAdminNo(String adminNo);
	Optional<String> findByAdminNo(String admin_no);
	List<Admin> getAdminList();
	void insertAdminInfo(Admin admin);
	Admin getInfoByAdminNo(String adminNo);
	void alterAdminInfo(Admin admin);
}
