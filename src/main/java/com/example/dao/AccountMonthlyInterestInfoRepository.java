package com.example.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.model.Account;
import com.example.model.AccountMonthlyInterestInfo;

public interface AccountMonthlyInterestInfoRepository extends ReactiveMongoRepository<AccountMonthlyInterestInfo, Integer>{

}
