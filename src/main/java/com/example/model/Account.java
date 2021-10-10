package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.constants.AccountStatus;

@Document
public class Account {
	
	@Id
	private String bsb;
	private String identification;
	private Date openingDate;
	private double balance; 
	private AccountStatus accountStatus;
	
	
	public String getBsb() {
		return bsb;
	}
	public void setBsb(String bsb) {
		this.bsb = bsb;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}
	@Override
	public String toString() {
		return "Account [bsb=" + bsb + ", identification=" + identification + ", openingDate=" + openingDate
				+ ", balance=" + balance + ", accountStatus=" + accountStatus + "]";
	}
	
	
   
}
