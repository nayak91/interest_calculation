package com.example.schedulers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.service.AccountService;

@Component
public class Scheduler {

	@Autowired
	private AccountService accountService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
   @Scheduled(cron = "0 10 23 L * ?")
   public void publishMonthlyInterestForAccounts() {
	   logger.info("publishMonthlyInterestForAccounts scheduler called"); 
	   accountService.findMonthlyInterestRatesOFAccounts();
   }
	
}
