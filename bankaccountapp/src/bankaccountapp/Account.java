package bankaccountapp;

public abstract class Account implements IRate {
	//List common properties for savings and checking account
	private String name;
	private String sSN;
	protected String accountNumber;
	
	private static int index = 10000;
	private double balance;
	protected double rate;

	public Account(String name, String sSN, double initDeposit ) {
		this.name = name;
		this.sSN = sSN;
		balance = initDeposit;
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();
	}
	
	public abstract void setRate();
	
	//Digit account number: depending on 1 savings or 2 Checking, last two digits of SSN
	//unique 5 digit number, 3 random digit number
	private String setAccountNumber() {
		String lastTwoSSN = sSN.length() > 2 ? sSN.substring(sSN.length() - 2) : sSN;
		int uniqueID = index;
		int randomNumber =(int) (Math.random() * Math.pow(10, 3));
		return lastTwoSSN + uniqueID + randomNumber;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued interest: €" + accruedInterest);
		printBalance();
	}
	
	//Transactions
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing: €" + amount);
		printBalance();
	}
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing: €" + amount);
		printBalance();
	}
	public void transfer(String toWhere, double  amount ) {
		balance = balance - amount; 
		System.out.println("Transfering €" + amount + " to " + toWhere);
		printBalance();
	}
	public void printBalance() {
		System.out.println("Your Balance is now: €" + balance);
	}
	
	public void showInfo( ) {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber + 
				"\nBALANCE: " + balance 
				);
	}
	
}
