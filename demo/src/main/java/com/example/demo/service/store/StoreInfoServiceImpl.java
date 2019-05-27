package com.example.demo.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.StoreInfo;
import com.example.demo.repository.store.StoreInfoDao;

@Transactional
@Service
public class StoreInfoServiceImpl implements StoreInfoService {
	
	@Autowired
	StoreInfoDao storeInfoDao;

	@Override
	public StoreInfo getStoreInfo(String acnt_store_no) {
		StoreInfo storeInfo = storeInfoDao.getByStore_no(acnt_store_no);
		
		return storeInfo;
	}

	@Override
	public List<StoreInfo> getStoreList() {
		List<StoreInfo> store = storeInfoDao.StoreList();
		return store;
	}

	@Override
	public void insertStoreInfo(StoreInfo store) {
		storeInfoDao.insertStoreInfo(store);
	}

	@Override
	public void updateStoreInfo(StoreInfo store) {
		storeInfoDao.updateStoreInfo(store);
		
	}
}
