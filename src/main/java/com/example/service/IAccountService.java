package com.example.service;

import com.example.model.Account;
import com.example.model.AccountsBalanceData;

import reactor.core.publisher.Flux;

public interface IAccountService {

	 void createAccount(Account account);
	 public void processAccountBalanceEventInfo(AccountsBalanceData accountsBalanceData);
	 public Flux<Account> findAll();
	 void closeAccount(Account account);
}
