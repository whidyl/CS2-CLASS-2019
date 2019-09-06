package edu.frontrange.csc161.a3;

import java.util.Date;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	Account () {
		setId(0);
		setBalance(0);
		setAnnualInterestRate(0);
		dateCreated = new Date();
	}
	
	Account (int id, double initialBalance) {
		this.setId(id);
		setBalance(initialBalance);
		setAnnualInterestRate(0);
		dateCreated = new Date();
	}
	
	public double getMonthlyInterestRate() {
		return annualInterestRate/12;
	}
	
	public double getMonthlyInterest() {
		//getMonthlyInterestRate() is a percentage (eg. 4.5%). 
		// We get the right multiplier by dividing it by 100.
		return (getMonthlyInterestRate()/100)*balance;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
}
