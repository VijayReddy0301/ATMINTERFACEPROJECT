package in.ineuron.controller;

import java.util.ArrayList;
import java.util.Scanner;

import in.ineuron.dto.BankTranscation;
import in.ineuron.service.IAtmInterface;
import in.ineuron.servicefactory.IAtmInterfaceServiceFactory;

public class MainApp {

	static Scanner scanner = null;

	public static void main(String[] args) {

		int count = 3;

		do {

			scanner = new Scanner(System.in);

			System.out.println();

			System.out.println();

			System.out.println("          ******** WELCOME TO ATM ********");

			System.out.println("          =================================");

			System.out.println();

			System.out.print("Enter UserName :: ");

			String username = scanner.next();

			System.out.print("Enter Pin :: ");

			Integer pin = scanner.nextInt();

			IAtmInterface atminterface = IAtmInterfaceServiceFactory.getIAtmInterfaceImpl();

			if (atminterface != null) {

				String result = atminterface.verifyUser(username, pin);

				if (result.equalsIgnoreCase("Failure")) {

					System.out.println("Incorrect Details");
					count--;

				} else {

					verfiedUser(atminterface, result);

					break;

				}

			}

		} while (count > 0);

	}

	public static void verfiedUser(IAtmInterface atminterface, String name) {

		System.out.println();

		System.out.println("*************************************************************");

		System.out.println("============== || Welcome ::  " + name + " || =================");

		System.out.println("**************************************************************");

		System.out.println();

		System.out.println("-------------------------------");

		System.out.println("Choose Option");

		System.out.println("-------------------------------");

		System.out.println("==================================");

		System.out.println(" 1. BALANCE ENQUIARY");

		System.out.println(" 2. DEPOSIT MONEY   ");

		System.out.println(" 3. WITHDRAW MONEY   ");

		System.out.println(" 4. TRANSFER MONEY   ");

		System.out.println(" 5. MINI STATEMENT   ");

		System.out.println(" 6. EXIT");

		System.out.println();

		System.out.println("==================================");

		System.out.println("Please Enter Your Option");

		String option = scanner.next();

		double bal;

		switch (option) {

		case "1":
			bal = atminterface.getBankBalance();

			System.out.println("====================================================");

			System.out.println("----------------------------------------------------");

			System.out.println("Your Account Balance is :: " + bal);

			System.out.println("----------------------------------------------------");

			System.out.println("====================================================");

			System.out.println();

			verfiedUser(atminterface, name);

			break;

		case "2":
			System.out.println("----------------------------------------------------");

			System.out.println("Enter The Amount To Be Deposited :: ");

			double amount = scanner.nextInt();

			if (amount < 0) {

				System.out.println("You Entered The wrong Amount");

				System.out.println();

				verfiedUser(atminterface, name);

				break;

			} else {

				atminterface.depositMoney(amount);

				System.out.println("----------------------------------------------------");

				System.out.println("Amount Deposited Sucessfully");

				System.out.println("----------------------------------------------------");

				atminterface.addBankTranscation("MYSELF", "Deposit", amount);

				System.out.println();

				verfiedUser(atminterface, name);

				break;

			}

		case "3":
			System.out.println("----------------------------------------------------");

			System.out.println("Enter The Amount To Be Withdraw :: ");

			double withdraw = scanner.nextInt();

			String res = atminterface.withdrawAmount(withdraw);

			if ("Success".equalsIgnoreCase(res)) {

				System.out.println("----------------------------------------------------");

				System.out.println(withdraw + "  :: Amount Withdraw Sucessfully");

				System.out.println("----------------------------------------------------");

				atminterface.addBankTranscation("MYSELF", "WITHDRAW", withdraw);

				System.out.println();

				verfiedUser(atminterface, name);

				break;

			} else {

				System.out.println("----------------------------------------------------");

				System.out.println("Sufficient Amount Is Not There In your Account Please Check Your Balance");

				System.out.println("----------------------------------------------------");

				System.out.println();

				verfiedUser(atminterface, name);

				break;

			}

		case "4":
			System.out.println("----------------------------------------------------");

			System.out.println("Enter The Account Number To Transfer :: ");

			String accountNo = scanner.next();

			String name1 = atminterface.transferAmount(accountNo);

			if (name1 != null) {

				System.out.println("----------------------------------------------------");

				System.out.println("The Details Of The AccountHolder");

				System.out.println("Name Of AccountHolder :: " + name1);

				System.out.println("Account Number :: " + accountNo);

				System.out.println("----------------------------------------------------");

				System.out.println("Enter The Amount To Be Transfered");

				double tranfer = scanner.nextDouble();

				String res1 = atminterface.withdrawAmount(tranfer);

				if ("Success".equalsIgnoreCase(res1)) {

					System.out.println("----------------------------------------------------");

					System.out.println(tranfer + "  :: Amount Transferd Sucessfully");

					System.out.println("----------------------------------------------------");

					atminterface.addBankTranscation(accountNo, "TRANSFER", tranfer);

					System.out.println();

					verfiedUser(atminterface, name);

					break;

				} else {

					System.out.println("----------------------------------------------------");

					System.out.println("Sufficient Amount Is Not There In your Account Please Check Your Balance");

					System.out.println("----------------------------------------------------");

					System.out.println();

					verfiedUser(atminterface, name);

					break;

				}

			} else {

				System.out.println("----------------------------------------------------");

				System.out.println("You Entered The Wrong Account Number Please Check Again");

				System.out.println("----------------------------------------------------");

				System.out.println();

				verfiedUser(atminterface, name);

				break;

			}

		case "5":
			ArrayList<BankTranscation> details = (ArrayList<BankTranscation>) atminterface.getBankTranscationDetails();

			System.out.println("==================================================================================");

			System.out.println("  PAYMENTMODE       AMOUNT                DATE                     ACCOUNTNUMBER");

			System.out.println("==================================================================================");

			for (BankTranscation detail : details) {

				System.out.println();

				System.out.println("  " + detail.getPaymentMode() + "          " + detail.getAmount() + "       "
						+ detail.getDate() + "     " + detail.getAccountNumber());

			}

			System.out.println("-------------------------------------------------------------------------");

			System.out.println();

			verfiedUser(atminterface, name);

			break;

		case "6":
			System.out.println("THANKS FOR USING OUR APPLICATION");

			System.exit(0);

			break;

		}

	}

}
