package com.example.demo.repository.store;

import java.util.List;

import com.example.demo.model.StoreInfo;

public interface StoreInfoDao {
	StoreInfo getByStore_no(String id);
	List<StoreInfo> StoreList();
	void insertStoreInfo(StoreInfo store);
}
