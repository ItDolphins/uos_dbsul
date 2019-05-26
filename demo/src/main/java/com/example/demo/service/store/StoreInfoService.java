package com.example.demo.service.store;

import java.util.List;

import com.example.demo.model.StoreInfo;

public interface StoreInfoService {
	StoreInfo getStoreInfo(String acnt_store_no);
	List<StoreInfo> getStoreList();
}
