
package in.ineuron.dto;

/**
 * @author Vijay Reddy
 * 
 *         This Class Gives Complete Details About USER User Name Password AND
 *         ACCOUNT BALANCE
 *
 */
public class Account {

	private double acccountBalance = 1000000;

	private String accountType;

	private String userName;

	private Integer pin;

	public Account(String accountType, String userName, Integer pin) {
		super();
		this.accountType = accountType;
		this.userName = userName;
		this.pin = pin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getAcccountBalance() {
		return acccountBalance;
	}

	public void setAcccountBalance(double acccountBalance) {
		this.acccountBalance = acccountBalance;
	}

	@Override
	public String toString() {
		return "Account [acccountBalance=" + acccountBalance + ", accountType=" + accountType + ", userName=" + userName
				+ ", pin=" + pin + "]";
	}

}
