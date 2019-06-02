package com.example.demo.service.release;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.example.demo.model.Release;
import com.example.demo.model.Stock;

public interface ReleaseService {
	void insertRelease(Stock stock, String rls_code, Timestamp rls_date,int rls_qnt);
	List<Release> getReleaseList();
}
