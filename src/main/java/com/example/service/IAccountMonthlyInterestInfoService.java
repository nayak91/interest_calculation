package com.example.service;

import com.example.model.AccountMonthlyInterestInfo;

import reactor.core.publisher.Flux;

public interface IAccountMonthlyInterestInfoService {

	public Flux<AccountMonthlyInterestInfo> findAll();
}
