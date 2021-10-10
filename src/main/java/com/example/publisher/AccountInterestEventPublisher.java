package com.example.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.model.AccountMonthlyInterestInfo;

@Component
public class AccountInterestEventPublisher {

	 @Autowired
	 private AmqpTemplate template;
	 
	  @Value("${account.interestInfo.event.rabbitmq.exchange}")
	  private String exchange;
	  
	  public void produceMsg(AccountMonthlyInterestInfo accountMonthlyInterestInfo) {
	    template.convertAndSend(exchange, "", accountMonthlyInterestInfo);
	    System.out.println("Sent message: " + accountMonthlyInterestInfo);
	  }
	  
}
