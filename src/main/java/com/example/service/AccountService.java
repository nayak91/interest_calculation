package com.example.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.constants.AccountStatus;
import com.example.dao.AccountInterestAccruedDailyHistoryRepository;
import com.example.dao.AccountMonthlyInterestInfoRepository;
import com.example.dao.AccountRepository;
import com.example.model.Account;
import com.example.model.AccountInterestAccruedDailyHistory;
import com.example.model.AccountMonthlyInterestInfo;
import com.example.model.AccountsBalanceData;
import com.example.publisher.AccountInterestEventPublisher;

import reactor.core.publisher.Flux;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AccountInterestAccruedDailyHistoryRepository accountInterestAccruedDailyHistoryRepository;
	
	@Autowired
	private AccountMonthlyInterestInfoRepository accountMonthlyInterestInfoRepository; 
	
	@Autowired
	private AccountInterestEventPublisher accountInterestEventPublisher;
	
	@Value("${interestRate}")
	private double interestRate;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	 public void createAccount(Account account)
	 {
		 account.setAccountStatus(AccountStatus.OPEN);
		 accountRepository.save(account);
		 logger.info("account create ->{}",account);
	 }
	 
	 public void updateAccount(Account account)
	 {
		 accountRepository.save(account);
		
	 }
	 
	 public Flux<Account> findAll() {
	        return accountRepository.findAll();
	    }
	 
	 
	 public void processAccountBalanceEventInfo(AccountsBalanceData accountsBalanceData)
	 {
		 for(Account account:accountsBalanceData.getAccountList())
		 {
			 double dailyInterest=interestRate/365*account.getBalance();
			 
			 AccountInterestAccruedDailyHistory accountInterestAccruedDailyHistory=new AccountInterestAccruedDailyHistory();
			 accountInterestAccruedDailyHistory.setBsb(account.getBsb());
			 accountInterestAccruedDailyHistory.setDate(accountsBalanceData.getBalanceDate());
			 accountInterestAccruedDailyHistory.setInterest(dailyInterest);
			 accountInterestAccruedDailyHistoryRepository.save(accountInterestAccruedDailyHistory);
		 }
	 }
	 
	 
	 public void findMonthlyInterestRatesOFAccounts()
	 {
		 logger.info("findMonthlyInterestRatesOFAccounts method called");
		 
		 List<AccountInterestAccruedDailyHistory> accountInterestAccruedDailyHistoryList= 
				 accountInterestAccruedDailyHistoryRepository.findByDate(new Date());
		 
		 logger.info("accountInterestAccruedDailyHistoryList -> {}",accountInterestAccruedDailyHistoryList);
		
		 for(AccountInterestAccruedDailyHistory accountInterestAccruedDailyHistory:accountInterestAccruedDailyHistoryList)
		 {
			 AccountMonthlyInterestInfo accountMonthlyInterestInfo=new AccountMonthlyInterestInfo();
			 accountMonthlyInterestInfo.setBsb(accountInterestAccruedDailyHistory.getBsb());
			 accountMonthlyInterestInfo.setInterest(accountMonthlyInterestInfo.getInterest());
			 accountMonthlyInterestInfo.setInterestMonth(Calendar.getInstance().get(Calendar.MONTH));
			 accountMonthlyInterestInfoRepository.save(accountMonthlyInterestInfo);
			 
			 
			 logger.info("accountMonthlyInterestInfo created {}",accountMonthlyInterestInfo);
			 
			 accountInterestEventPublisher.produceMsg(accountMonthlyInterestInfo);
			 
			 logger.info("event {} published to queue",accountMonthlyInterestInfo);
		 }
		
		 
	 }
	 
	 public void closeAccount(Account account)
	 {
		 logger.info("closeAccount ->{}",account);
		 account.setAccountStatus(AccountStatus.CLOSED);
		 updateAccount(account);
		 AccountInterestAccruedDailyHistory accountInterestAccruedDailyHistory= accountInterestAccruedDailyHistoryRepository.findFirstByBsbOrderByDateDesc(account.getBsb());
	
		 AccountMonthlyInterestInfo accountMonthlyInterestInfo=new AccountMonthlyInterestInfo();
		 accountMonthlyInterestInfo.setBsb(accountInterestAccruedDailyHistory.getBsb());
		 accountMonthlyInterestInfo.setInterest(accountMonthlyInterestInfo.getInterest());
		 accountMonthlyInterestInfo.setInterestMonth(Calendar.getInstance().get(Calendar.MONTH));
		 accountMonthlyInterestInfoRepository.save(accountMonthlyInterestInfo);
		 
		 
		 logger.info("accountMonthlyInterestInfo created {}",accountMonthlyInterestInfo);
		 
		 accountInterestEventPublisher.produceMsg(accountMonthlyInterestInfo);
		 
		 logger.info("event {} published to queue",accountMonthlyInterestInfo);
	 }
	
}
