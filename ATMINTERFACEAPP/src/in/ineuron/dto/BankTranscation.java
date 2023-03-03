package in.ineuron.dto;

import java.util.Date;

public class BankTranscation {

	private String accountNumber;

	private java.util.Date date;

	private String paymentMode;

	private double amount;

	public BankTranscation(String accountNumber, Date date, String paymentMode, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.date = date;
		this.paymentMode = paymentMode;
		this.amount = amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "BankTranscation [accountNumber=" + accountNumber + ", date=" + date + ", paymentMode=" + paymentMode
				+ ", amount=" + amount + "]";
	}

}
