package edu.frontrange.csc161.a3;

public class SavingsAccount extends Account {
	@Override
	public void withdraw(double amount) {
		double balanceAfterWithdraw = getBalance() - amount;
		if (getBalance() - amount >= 0) {
			setBalance(balanceAfterWithdraw);
		} else {
			System.out.println("Money was not withdrawn because balance cannot be negative.");
		}
	}
}
