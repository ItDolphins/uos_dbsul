package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountDao;

@Transactional
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDao accountDao;

	@Override
	public Account getAccount(String username) {
		Account account = accountDao.getAccountByUsername(username);
		return account;
	}

}
