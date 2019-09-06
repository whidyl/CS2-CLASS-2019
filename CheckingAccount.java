package edu.frontrange.csc161.a3;

public class CheckingAccount extends Account {
	private double overdraftLimit = 100.00;
	
	@Override
	public void withdraw(double amount) {
		double balanceAfterWithdraw = getBalance() - amount;
		if (getBalance() - amount > overdraftLimit * -1) {
			setBalance(balanceAfterWithdraw);
		} else {
			System.out.println("Money was not withdrawn because overdraft was reached.");
		}
	}

	public double getOverdraftLimit() {
		return overdraftLimit;
	}

	public void setOverdraftLimit(double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}
}
