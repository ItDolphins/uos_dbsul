package com.example.demo.repository.store;

import java.util.List;

import com.example.demo.dto.StoreInfo;

public interface StoreInfoDao {
	StoreInfo getByStore_no(int acnt_store_no);
	List<StoreInfo> StoreList();
	void insertStoreInfo(StoreInfo store);
	void updateStoreInfo(StoreInfo store);
	List<Integer> findStore_noByAdmin_no(int admin_no);
	}