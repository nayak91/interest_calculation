package com.example.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Account;
import com.example.service.AccountService;

@Component
public class AccountOpeningEventListener {
	
	  @Autowired
	  private AccountService accountService;
	  
	  private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @RabbitListener(queues = "${account.opening.queue}")
	  public void recievedMessage(Account account) {
		 logger.info("account opening event->{}",account);
		 accountService.createAccount(account);
	  }

}
