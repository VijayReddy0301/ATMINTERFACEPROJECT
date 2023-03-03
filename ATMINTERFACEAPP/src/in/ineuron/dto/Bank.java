package in.ineuron.dto;





import java.util.ArrayList;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

/**
 * BANK CLASS
 * 
 * IN THIS CLASS WE ADD DETAILS OF THE CUSTOMER
 * 
 * GET THE CUSTOMER DETAILS AND SEND TO THE SERVICE PACKAGE OF IMPLEMENTATION CLASS OF IATMINTERFACE
 * 
 * VERFYING THE ACCOUNT HOLDER IS THERE ARE NOT 
 *
 */
public class Bank {
	
	static HashMap<String,AccountHolder> accountholders = null;
	
	public  static void addAccountHolder() {
			
		
		java.util.Date date = new Date();
		
		
		accountholders = new HashMap<String,AccountHolder>();
		
			
			Account account = new Account("Savings", "Vijay123", 12345);
			
			ArrayList<BankTranscation> details = new ArrayList<BankTranscation>();
			
			
			details.add(new BankTranscation("MYSELF", date, "DEPOSIT", 19990));
			
			details.add(new BankTranscation("987654321", date, "TRANSFER", 50000));
			
			details.add(new BankTranscation("MYSELF", date, "WITHDRAW", 20000));
			
			
			AccountHolder accountholder1 = new AccountHolder("Vijay Reddy", "123456789", "Peddapuram", "9676797487", account,details);
			
			
			

			Account account1 = new Account("Savings", "Teja123", 67891);
			
			ArrayList<BankTranscation> details1 = new ArrayList<BankTranscation>();
			

			details1.add(new BankTranscation("MYSELF", date, "DEPOSIT", 100000));
			
			details1.add(new BankTranscation("123456789", date, "TRANSFER", 20000));
			
			details1.add(new BankTranscation("MYSELF", date, "WITHDRAW", 50000));
			
			AccountHolder accountholder2 = new AccountHolder("Teja Reddy", "987654321", "Peddapuram", "9998777877", account1,details1);
			
			
			accountholders.put(account.getUserName(), accountholder1);
			
			accountholders.put(account1.getUserName(),accountholder2);
		
			}
	
	
	public AccountHolder getAccountHolderInfromation(String userName) {
		
		
		addAccountHolder();
		
		
		
		if(accountholders.containsKey(userName)) {
			
			return accountholders.get(userName);
			
			
		}
		
		return null;
		
		
}
	
	public String verifyAccountHolder(String accountNumber) {
		
		addAccountHolder();
		
		Collection<AccountHolder>  values = accountholders.values();
		
		for(AccountHolder holder:values) {
			
			if(holder.getAccountHolderNumber().equals(accountNumber)) {
				
				return holder.getAccountHolderName();
			}
			
		}
		
		return null;
		
		
		
		
		
	}
	
	
	

}
