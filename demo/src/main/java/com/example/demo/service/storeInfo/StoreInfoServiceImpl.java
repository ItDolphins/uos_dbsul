package com.example.demo.service.storeInfo;

import com.example.demo.service.storeInfo.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StoreInfo;
import com.example.demo.repository.storeInfo.StoreInfoDao;

@Service
public class StoreInfoServiceImpl implements StoreInfoService {
	
	@Autowired
	StoreInfoDao storeInfoDao;

	@Override
	public StoreInfo getStoreInfo(String acnt_store_no) {
		StoreInfo storeInfo = storeInfoDao.getByAcnt_store_no(acnt_store_no);
		
		return storeInfo;
	}

}
