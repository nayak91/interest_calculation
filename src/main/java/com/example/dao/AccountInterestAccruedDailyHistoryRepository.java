package com.example.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.ReactiveMongoRepositoryConfigurationExtension;
import com.example.model.Account;
import com.example.model.AccountInterestAccruedDailyHistory;

public interface AccountInterestAccruedDailyHistoryRepository extends ReactiveMongoRepository<AccountInterestAccruedDailyHistory, Integer>{

	List<AccountInterestAccruedDailyHistory> findByDate(Date date);
	AccountInterestAccruedDailyHistory  findFirstByBsbOrderByDateDesc(String bsb);
}
