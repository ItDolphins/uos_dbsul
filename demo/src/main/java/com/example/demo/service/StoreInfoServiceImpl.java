package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StoreInfo;
import com.example.demo.repository.StoreInfoDao;

@Service
public class StoreInfoServiceImpl implements StoreInfoService{
	
	@Autowired
	StoreInfoDao storeInfoDao;

	@Override
	public StoreInfo getStoreInfo(String id) {
		StoreInfo storeInfo = storeInfoDao.getStoreInfoById(id);
		
		return storeInfo;
	}

	@Override
	public String getStoreNumByAcntId(String id) {
		String result = storeInfoDao.getStoreNumByAcntId(id);
		return result;
	}

}
