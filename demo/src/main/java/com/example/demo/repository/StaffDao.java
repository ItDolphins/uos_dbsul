package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Staff;

public interface StaffDao {
	List<Staff> findByStoreNoa(String storeNo);
}
