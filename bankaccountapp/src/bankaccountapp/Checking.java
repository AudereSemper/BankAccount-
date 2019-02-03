package bankaccountapp;

public class Checking extends Account {
	//List specific properties to a checking account
	int debitCardNumber;
	int debitCardPIN;
	
	
	//Constructor to initialize checking account properties
	public Checking(String name, String sSN, double initDeposit) {
		super(name, sSN, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}	
	
	@Override
	public void setRate() {
		rate = getBaseRate() * .15;
	}
	
	private void setDebitCard() {
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPIN = (int) (Math.random() * Math.pow(10, 3));
		System.out.println("CARD: " + debitCardNumber + " Pin: " + debitCardPIN);
	}
	
	
	
	public void showInfo( ) {
		super.showInfo();
		System.out.println("Your checking account features" +
				"\nDebit card number: " + debitCardNumber + 
				"\nDebit card pin: " + debitCardPIN + "\n" +
				"\nRate: " + rate + "%" 
				);
	}
	
	//List any methods specific to the checking account
}
