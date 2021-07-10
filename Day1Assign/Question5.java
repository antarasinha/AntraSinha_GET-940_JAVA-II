
class Account{
	private int accountNo;
	private double accountBalance;
	private String accountPassword;
	
	private static String bankName;
	
	
	Account(){}
	
	Account(int acc, double amount, String pass){
		accountNo=acc;
		amount=accountBalance;
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
		
		System.out.println("=============================");
	}
	
	

}


public class Question5 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			Account.setBankName("State Bank of India");
			Account acnt=new Account(10235,40000.0,"8379732698");
			
			acnt.displayAccount();
			

	}

}
