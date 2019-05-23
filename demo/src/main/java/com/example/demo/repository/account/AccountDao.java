package com.example.demo.repository.account;

import com.example.demo.model.Account;

public interface AccountDao {
	Account getAccountByUsername(String  username);
}
