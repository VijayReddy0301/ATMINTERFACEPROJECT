package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.BankTranscation;

/**
 * @author Vijay Reddy
 * 
 *         THIS ARE THE SERVICES OFFERED BY THE APPLICATION
 *
 */
public interface IAtmInterface {

	public String verifyUser(String username, Integer pin);

	public double getBankBalance();

	public void depositMoney(double amout);

	public String withdrawAmount(double amount);

	public String transferAmount(String accountNumber);

	public List<BankTranscation> getBankTranscationDetails();

	public void addBankTranscation(String accNum, String paymentMode, Double amount);

}
