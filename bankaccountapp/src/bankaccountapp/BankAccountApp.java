package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account> ();
		
		/*
		Checking checkAccount1 = new Checking("Federico Castorina", "13213423", 1500);
		
		Savings saveAccount1 = new Savings ("Daniela Arezzi", "2233664461", 2500);
		
		checkAccount1.showInfo();
		saveAccount1.showInfo();
		
		saveAccount1.compound();
		
		*/
		String file = "C:\\Users\\fedec\\OneDrive\\Desktop\\File da leggere\\accounts.csv";
		List<String[]> newAccountsHolders = utilities.CSV.read(file); 
		System.out.println("NEW ACCOUNTS");
		for(String[] accountHolder : newAccountsHolders ) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);

			if(accountType.equals(" Savings")) {
				accounts.add(new Savings(name, sSN, initDeposit));
			}else if(accountType.equals(" Checking")) {
				System.out.println("Open a CHECKING account");
				accounts.add(new Checking(name, sSN, initDeposit));
			}else {
				System.out.println("ERROR: impossible to read account type");
			}
		}
		
		for(Account acc : accounts ) {
			System.out.println("\n---------------");
			acc.showInfo();
		}
		
	}
}
