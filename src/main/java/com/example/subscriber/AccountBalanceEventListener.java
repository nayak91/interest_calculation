package com.example.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Account;
import com.example.model.AccountsBalanceData;
import com.example.service.AccountService;

public class AccountBalanceEventListener {

	@Autowired
	private AccountService accountService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @RabbitListener(queues = "${account.balance.event.rabbitmq.queue}")
	  public void recievedMessage(AccountsBalanceData accountsBalanceData) {
	    logger.info("AccountBalanceEventListener->{}",accountsBalanceData);
	    accountService.processAccountBalanceEventInfo(accountsBalanceData);
	  }
}
