package com.example.demo.repository;

import com.example.demo.model.StoreInfo;

public interface StoreInfoDao {
	StoreInfo getByAcnt_store_no(String id);
}
