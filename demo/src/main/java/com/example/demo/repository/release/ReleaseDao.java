package com.example.demo.repository.release;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.example.demo.model.Release;
import com.example.demo.model.Stock;

public interface ReleaseDao {
	List<Release> getReleaseList();
	void insertRelease(Stock stock,String rls_code,Timestamp rls_date,int rls_qnt);
	int getMaxRlsno();
}
