package com.example.demo.service.release;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Release;
import com.example.demo.model.Stock;
import com.example.demo.repository.release.ReleaseDao;

@Service
@Transactional
public class ReleaseServiceImpl implements ReleaseService{

	@Autowired
	ReleaseDao releaseDao;
	
	@Override
	public void insertRelease(Stock stock, String rls_code, Timestamp rls_date,int rls_qnt) {
		releaseDao.insertRelease(stock, rls_code, rls_date,rls_qnt);
		
	}

	@Override
	public List<Release> getReleaseList() {
		List<Release> rlsList = releaseDao.getReleaseList();
		return rlsList;
	}


}
