import java.util.*;


class InvalidAmountException extends Exception{
	
	InvalidAmountException(String strs)
	{
		super(strs);
	}
}

class InsufficientFundException extends Exception{
	
	InsufficientFundException(String strs){
		super(strs);
	}
}

class Bank{
	
	private int accountNumber;
	private double balance;
	private String password;
	
	Bank(int accno, Double amt)
	{
		accountNumber=accno;
		balance=amt;
	}
	
	void checkAmount(double amount) throws InsufficientFundException,InvalidAmountException
	{
		System.out.println("Amount is Checking");
		if(amount<0)
			throw new InvalidAmountException("Invalid Amount!");
		
		if(amount>balance)
			throw new InsufficientFundException("Amount cannot be greater than the balance");
		
		System.out.println("Amount is checked Perfectly");
	}
	
}


public class Question1{

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Bank b1=new Bank(216,30000.0);
		double amount=scan.nextDouble();
		try {
			
			
			b1.checkAmount(amount);
		}
		
		catch(InvalidAmountException e)
		{
			System.out.println(e.getMessage());
		}
		catch(InsufficientFundException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
