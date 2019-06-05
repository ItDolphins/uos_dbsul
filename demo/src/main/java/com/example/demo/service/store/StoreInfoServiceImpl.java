package com.example.demo.service.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.StoreInfo;
import com.example.demo.repository.store.StoreInfoDao;

@Transactional
@Service
public class StoreInfoServiceImpl implements StoreInfoService {
	
	@Autowired
	StoreInfoDao storeInfoDao;

	@Override
	public StoreInfo getStoreInfo(int acnt_store_no) {
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

	@Override
	public List<Integer> getStore_noList(int admin_no){
		List<Integer> store_noList = storeInfoDao.findStore_noByAdmin_no(admin_no);
		return  store_noList;
	}
}