package com.example.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.model.Account;


public interface AccountRepository extends ReactiveMongoRepository<Account, Integer>{
	

}
