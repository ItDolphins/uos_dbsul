package com.example.demo.service;

import com.example.demo.model.StoreInfo;

public interface StoreInfoService {
	StoreInfo getStoreInfo(String id);
	String getStoreNumByAcntId(String id);
}
