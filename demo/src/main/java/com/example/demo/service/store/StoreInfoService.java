package com.example.demo.service.store;

import java.util.List;

import com.example.demo.model.StoreInfo;

public interface StoreInfoService {
	StoreInfo getStoreInfo(int acnt_store_no);
	List<StoreInfo> getStoreList();
	void insertStoreInfo(StoreInfo store);
	void updateStoreInfo(StoreInfo store);
}
