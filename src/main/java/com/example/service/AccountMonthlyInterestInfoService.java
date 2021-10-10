package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.AccountMonthlyInterestInfoRepository;
import com.example.model.AccountMonthlyInterestInfo;

import reactor.core.publisher.Flux;

@Service
public class AccountMonthlyInterestInfoService implements IAccountMonthlyInterestInfoService {
	
	@Autowired
	private AccountMonthlyInterestInfoRepository accountMonthlyInterestInfoRepository;
	
	public Flux<AccountMonthlyInterestInfo> findAll()
	{
		return accountMonthlyInterestInfoRepository.findAll();
	}

}
