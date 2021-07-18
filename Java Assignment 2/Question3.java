

interface  ATM{
	
	public void withdraw(int accountNumber, double amount);
	public void changePassword(int accountNumber, String oldPassword, String newPassword);
	public void checkBalance();
}

class SbiAtm implements ATM{
	
	private int accountNumber;
	private String password;
	private double balance;
	
	SbiAtm(int acc, String pass,double bal)
	{
		accountNumber=acc;
		password= pass;
		balance=bal;
	}
	
	public void withdraw(int accountNumber, double amount) {
		if(this.accountNumber==accountNumber) {
			balance=balance-amount;
			System.out.println("Amount withdrawn from SBI accno: "+accountNumber+ " of Rs. "+amount );
		}
		else {
			System.out.println("Invalid Account Number..");
		}
	}
	
	public void changePassword(int accountNumber, String oldPassword, String newPassword) {
		if(oldPassword==password)
			System.out.println("The password is changed of accno "+ accountNumber+"old password was "+oldPassword+"and new updated password is: "+newPassword);
		else
			System.out.println("Password Entered is Incorrect!");
	}
	public void checkBalance() {
		System.out.println("The balance left is "+balance);
	}
}

class IciciAtm implements ATM{
	private int accountNumber;
	private String password;
	private double balance;
	
	
	IciciAtm(int acc, String pass,double bal)
	{
		accountNumber=acc;
		password= pass;
		balance=bal;
	}
	
	
	
	public void withdraw(int accountNumber, double amount) {
		
		if(this.accountNumber==accountNumber) {
			balance=balance-amount;
			System.out.println("Amount withdrawn from ICICI accno: "+accountNumber+ " of Rs. "+amount );
		}
		else {
			System.out.println("Invalid Account Number..");
		}
		
	}
	
	public void changePassword(int accountNumber, String oldPassword, String newPassword) {
		
		if(oldPassword==password)
			System.out.println("The password is changed of accno "+ accountNumber+"old password was "+oldPassword+"and new updated password is: "+newPassword);
		else
			System.out.println("Password Entered is Incorrect!");
	}
	public void checkBalance() {
		System.out.println("The balance left is "+balance);
	}
	
}





public class Question3 {
	public static void main(String[] args) {
		SbiAtm sbi=new SbiAtm(1221,"Abc123",76000);
			sbi.withdraw(1221, 6000);
			sbi.checkBalance();
			sbi.changePassword(1221, "Abc123", "Aef123");
		IciciAtm ic=new IciciAtm(1201,"DEF276",45000);
		ic.checkBalance();
		ic.withdraw(1201, 5000);
		ic.changePassword(1201, "DEF276", "Ajh23");
	}
}
