package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountDao;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDao accountDao;

	@Override
	public String getPw(String Id) {
		String account = accountDao.getPw(Id);
		return account;
	}

}