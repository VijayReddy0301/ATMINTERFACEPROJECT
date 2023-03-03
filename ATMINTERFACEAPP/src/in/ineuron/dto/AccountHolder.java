package in.ineuron.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Vijay Reddy
 * 
 * 
 *         This Class Gives Complete Information (Details) Of The Customer Like
 *         ACCOUNT NAME, ACCOUNT NUMBER
 * 
 *         ACCOUNT ADDRESS And ACCOUNT PHONE NUMBER AND TRANSCATION DETAILS
 * 
 *         CONSTRUCTOR IS USED TO INITLIASE THE VALUES
 * 
 *         Here We Are Injecting Account Object to AccountHolder
 *         Class(DEPENDENCY INJECTION)
 *
 */
public class AccountHolder implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accountHolderName;

	private String accountHolderNumber;

	private String accountHolderAddress;

	private String accountHolderPhoneNumber;

	Account account;

	List<BankTranscation> details;

	public AccountHolder(String accountHolderName, String accountHolderNumber, String accountHolderAddress,
			String accountHolderPhoneNumber, Account account, List<BankTranscation> details) {
		super();
		this.accountHolderName = accountHolderName;
		this.accountHolderNumber = accountHolderNumber;
		this.accountHolderAddress = accountHolderAddress;
		this.accountHolderPhoneNumber = accountHolderPhoneNumber;
		this.account = account;
		this.details = details;
	}

	public List<BankTranscation> getDetails() {
		return details;
	}

	public void setDetails(List<BankTranscation> details) {
		this.details = details;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountHolderNumber() {
		return accountHolderNumber;
	}

	public void setAccountHolderNumber(String accountHolderNumber) {
		this.accountHolderNumber = accountHolderNumber;
	}

	public String getAccountHolderAddress() {
		return accountHolderAddress;
	}

	public void setAccountHolderAddress(String accountHolderAddress) {
		this.accountHolderAddress = accountHolderAddress;
	}

	public String getAccountHolderPhoneNumber() {
		return accountHolderPhoneNumber;
	}

	public void setAccountHolderPhoneNumber(String accountHolderPhoneNumber) {
		this.accountHolderPhoneNumber = accountHolderPhoneNumber;
	}

	@Override
	public String toString() {
		return "AccountHolder [accountHolderName=" + accountHolderName + ", accountHolderNumber=" + accountHolderNumber
				+ ", accountHolderAddress=" + accountHolderAddress + ", accountHolderPhoneNumber="
				+ accountHolderPhoneNumber + ", account=" + account + ", details=" + details + "]";
	}

}
