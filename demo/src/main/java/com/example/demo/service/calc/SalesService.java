package com.example.demo.service.calc;

import com.example.demo.model.Sales;
import com.example.demo.repository.calc.SalesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service @Transactional
public class SalesService {

	@Autowired
	SalesDao salesDao;


	public List<Sales> getSalesList(int store_no){
		List<Sales> salesList = salesDao.findByStore_no(store_no);
		return  salesList;
	}

	public boolean isSalesExist(int store_no , Date sales_date){

		List<Sales> salesList = salesDao.findByStore_noAndSales_date(store_no, sales_date);
		return salesList.size() != 0;
	}

	public  int calculateSales_amt(int store_no, Date sales_date){
		int sales_amt = salesDao.getSales_amt(store_no, sales_date);
		return sales_amt;
	}

	public void insertSales(Sales sales){
		salesDao.insertSales(sales);
	}

	public void updateSales(Sales sales){
		salesDao.updateSales(sales);
	}



}
