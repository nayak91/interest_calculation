package com.example.model;

import java.util.Date;
import java.util.List;

public class AccountsBalanceData {

	private Date balanceDate;
	private List<Account> accountList;
	
	public Date getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	
	
}
