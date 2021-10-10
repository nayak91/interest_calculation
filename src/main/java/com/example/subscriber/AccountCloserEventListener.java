package com.example.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Account;
import com.example.service.AccountService;

public class AccountCloserEventListener {

	@Autowired
	  private AccountService accountService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 @RabbitListener(queues = "${account.closing.event.rabbitmq.queue}")
	  public void recievedMessage(Account account) {
		 
		 logger.info("account closing event->{}",account);
		 accountService.closeAccount(account);
	    
	  }
	 
}
