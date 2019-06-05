package com.example.demo.service.busireq;

import com.example.demo.dto.WrhsInfo;
import com.example.demo.repository.Busireq.WrhsInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class WrhsInfoService  {

	@Autowired
	WrhsInfoDao wrhsInfoDao;

	public List<WrhsInfo> getWrhsInfoList(int store_no){
		List<WrhsInfo> wrhsInfoList = wrhsInfoDao.findByStore_no(store_no);
		return wrhsInfoList;
	}
}
