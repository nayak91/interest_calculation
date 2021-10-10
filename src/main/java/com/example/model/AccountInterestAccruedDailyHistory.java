package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AccountInterestAccruedDailyHistory {

	@Id
	private int id;
	private String bsb;
	private  Date date;
	private double interest;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBsb() {
		return bsb;
	}
	public void setBsb(String bsb) {
		this.bsb = bsb;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	@Override
	public String toString() {
		return "AccountInterestAccruedDailyHistory [id=" + id + ", bsb=" + bsb + ", date=" + date + ", interest="
				+ interest + "]";
	}
	
	
}
