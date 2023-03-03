package in.ineuron.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.ineuron.dto.Account;
import in.ineuron.dto.AccountHolder;
import in.ineuron.dto.Bank;
import in.ineuron.dto.BankTranscation;

/**
 * THIS CLASS GIVES COMPLETE IMPLEMENTATION FOR THE INTERFACE
 * 
 * VERIFYUSER METHOD VERFIES WHEATHER THE CUSTOMER IS GENINUE OR NOT
 * 
 * GETBANKBALANCE METHOD RETURNS THE TOTAL AMOUNT PRESENT IN ACCOUNT HOLDER
 * 
 * DEPOSITMONEY METHOD CALLS WHEN USER DEPOSITS THE MONEY
 * 
 * WITHDRAWMONEY METHOD CALLS WHEN USER WANTS TO WITHDRAW THE AMOUNT,IF WITHDRAW
 * AMOUNT IS GREATER THAN AMOUNT PRESENT IN ACCOUNT IT GIVES ERROR
 * 
 * TRANSFER AMOUNT METHOD IS FOR TRANSFERING MONEY FROM ONE ACCOUNT TO ANOTHER
 * ACCOUNT
 * 
 * 
 *
 */
public class IAtmInterfaceImpl implements IAtmInterface {

	Bank bank = new Bank();

	AccountHolder accountholder = null;

	public String verifyUser(String username, Integer pin) {

		accountholder = bank.getAccountHolderInfromation(username);

		if (accountholder != null) {

			Account account = accountholder.getAccount();

			Integer atmPin = account.getPin();

			String name = accountholder.getAccountHolderName();

			if (atmPin.intValue() == pin) {

				return name;

			} else {

				return "Failure";
			}

		}

		return "failure";

	}

	@Override
	public double getBankBalance() {

		Account account = accountholder.getAccount();

		double balance = account.getAcccountBalance();

		return balance;

	}

	@Override
	public void depositMoney(double amount) {

		Account account = accountholder.getAccount();

		double balance = account.getAcccountBalance();

		double newBalance = balance + amount;

		account.setAcccountBalance(newBalance);

	}

	public String withdrawAmount(double amount) {

		Account account = accountholder.getAccount();

		double balance = account.getAcccountBalance();

		if (amount > balance) {

			return "Failure";

		} else {

			balance = balance - amount;

			account.setAcccountBalance(balance);

			return "Success";

		}

	}

	public String transferAmount(String accountNumber) {

		String name = bank.verifyAccountHolder(accountNumber);

		if (name != null) {

			return name;

		}

		return null;

	}

	public List<BankTranscation> getBankTranscationDetails() {

		ArrayList<BankTranscation> detailsss = (ArrayList<BankTranscation>) accountholder.getDetails();

		return detailsss;

	}

	public void addBankTranscation(String accNum, String paymentMode, Double amount) {

		String payment, accountNum;

		if (accNum != null) {

			accountNum = accNum;

		} else {

			accountNum = "";
		}

		if (paymentMode != null) {

			payment = paymentMode;

		} else {

			payment = "";
		}

		java.util.Date date = new Date();

		ArrayList<BankTranscation> detailss = (ArrayList<BankTranscation>) accountholder.getDetails();

		detailss.add(new BankTranscation(accountNum, date, payment, amount));

	}

}
