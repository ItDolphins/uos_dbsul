package com.example.demo.repository.admin;

import java.util.List;
import java.util.Optional;

public interface AdminDao {
	List<String> adminNameList();
	String getByAdminNo(String adminNo);
	Optional<String> findByAdminNo(String admin_no);
}
