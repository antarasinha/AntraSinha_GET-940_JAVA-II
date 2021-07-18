abstract class Accounts{
	
	Accounts(){}
	protected double accountbalance;
	Accounts(double bal){
		accountbalance=bal;
	}
	abstract void withdraw(double amount);
	
	void displayAccount() {
		System.out.println("Balance left"+accountbalance);
	}
}

class SavingAccount extends Accounts{

	  SavingAccount(){}
      SavingAccount(double bal){
		super(bal);	
		accountbalance=bal;
	}
	void withdraw(double amount) {
		// TODO Auto-generated method stub
	 
		accountbalance-=amount;
	}
	
	void displayAccount() {
		System.out.println("Account Balance "+accountbalance);
	}
}

class CurrentAccounts extends Accounts{
	
	CurrentAccounts(){}
	CurrentAccounts(double bal){
		super(bal);
		accountbalance=bal;
	}
	void withdraw(double amount) {
		accountbalance-=amount;
	}
	
	void displayAccount() {
		System.out.println("OverDraft Limit left "+accountbalance);
	}
	
}
public class Qustion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SavingAccount savacc=new SavingAccount(40000);
		savacc.withdraw(12000);
		savacc.displayAccount();
		CurrentAccounts curacc=new CurrentAccounts(35000);
		curacc.withdraw(20000);
		curacc.displayAccount();
	}

}
