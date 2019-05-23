package com.example.demo.service.account;

import com.example.demo.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.repository.account.AccountDao;

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
