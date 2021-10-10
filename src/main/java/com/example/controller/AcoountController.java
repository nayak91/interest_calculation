package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Account;
import com.example.model.AccountMonthlyInterestInfo;
import com.example.service.AccountService;
import com.example.service.IAccountMonthlyInterestInfoService;
import com.example.service.IAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Mono;


@RestController
public class AcoountController {

	  @Autowired
	  private IAccountService accountService;
	  
	  @Autowired
	  private IAccountMonthlyInterestInfoService accountMonthlyInterestInfoService;
	  
	  private final Logger logger = LoggerFactory.getLogger(this.getClass());
	  
	    @RequestMapping(value ="/findAccountsInfo", method = RequestMethod.POST,produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	    public  Flux<Account> findAccountsInfo() {
	    
	    	logger.info("findAccountsInfo controller called");
	    	return accountService.findAll();
	    }
	 
	    @RequestMapping(value ="/findAccountMonthlyInterestInfo", method = RequestMethod.POST,produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	    public  Flux<AccountMonthlyInterestInfo> findAccountMonthlyInterestInfo() {
	    
	    	logger.info("AccountMonthlyInterestInfo controller called");
	    	return accountMonthlyInterestInfoService.findAll();
	    }
	    
}
