package com.example.demo.service.admin;

import java.util.List;

public interface AdminService {
	List<String> getAdminName();
	boolean checkByAdminNo(String admin_no);
}
