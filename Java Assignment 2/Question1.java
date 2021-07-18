import java.util.*;

class Account{
	private int accountNo;
	private double accountBalance;
	private String accountPassword;
	
	private static String bankName;
	
	
	Account(){}
	
	Account(int acc, double amount, String pass){
		accountNo=acc;
		accountBalance=amount;
		accountPassword=pass;
	}
	
	static void setBankName(String name)
	{
		bankName=name;
	}
	
	void displayAccount()
	{
		System.out.println("Account  No:"+accountNo);
		System.out.println("Account Balance:"+ accountBalance);
		System.out.println("Account Password"+ accountPassword);
		System.out.println("Bank Name: "+bankName);		
	}
	
}

class SavingsAccount extends Account{
	
	private double minimumBalance;
	
	SavingsAccount(){}
	
	SavingsAccount(int acc, double amount, String pass, String name, double minbal)
	{
		super(acc, amount, pass);
		Account.setBankName(name);
		minimumBalance=minbal;
	}
	
	void displayAccount()
	{
		super.displayAccount();
		System.out.println("Minimum Balance "+minimumBalance);
	}
	
	
}

class CurrentAccount extends Account{
	
	private double overdraftLimitAmount;
	
	CurrentAccount(){}
	
	CurrentAccount(int acc, double amount, String pass, String name, double overdraft)
	{
		super(acc, amount, pass);
		Account.setBankName(name);
		overdraftLimitAmount=overdraft;
	}
	
	void displayAccount()
	{
		super.displayAccount();
		System.out.println("Overdraft LimitAmount "+overdraftLimitAmount);
	}
}



public class Question1 {

	public static void main(String args[])
	{
		
		SavingsAccount savacc=new SavingsAccount(232,12000,"Abc1234","SBI",3000);
		savacc.displayAccount();
		
		System.out.println("=============================");
		CurrentAccount curacc=new CurrentAccount(232,27000,"cde1234","ICICI",3000);
		curacc.displayAccount();
		
		System.out.println("=============================");
	}
}
