package com.example.demo.repository;

import com.example.demo.model.StoreInfo;

public interface StoreInfoDao {
	StoreInfo getByStore_no(String id);
}
