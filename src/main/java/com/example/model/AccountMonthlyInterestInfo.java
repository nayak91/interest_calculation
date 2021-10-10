package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AccountMonthlyInterestInfo {

	@Id
	private int id;
	
	private String bsb;
	
	private int interestMonth;
	
	private double interest;

	public String getBsb() {
		return bsb;
	}

	public void setBsb(String bsb) {
		this.bsb = bsb;
	}

	public int getInterestMonth() {
		return interestMonth;
	}

	public void setInterestMonth(int interestMonth) {
		this.interestMonth = interestMonth;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "AccountMonthlyInterestInfo [id=" + id + ", bsb=" + bsb + ", interestMonth=" + interestMonth
				+ ", interest=" + interest + "]";
	}
	
	
	
}
