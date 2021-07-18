import java.util.List;
import java.util.*;
interface  AccountDao{

	 void addAnAccount(Account account);
	 void withdraw(int accountNumber,double amount) throws InvalidAmountException,InsufficientFundException;
	 void checkBalance(int accountNumber);
	 void changePassword(int accountNumber,String oldPassword,String newPassword);
	
	 void getAccountDetails(int accountNumber);
	
}

class AccountImpl implements AccountDao{
	 
	List<Account>accountlist=new ArrayList<>();
	
	public void addAnAccount(Account account) {
		accountlist.add(account);
	}
	
	public void withdraw(int accountNumber,double amount) throws InvalidAmountException,InsufficientFundException {
		
		Iterator<Account>it=accountlist.iterator();
		int flag=0;
		if(amount<0)
		{
			throw new InvalidAmountException("Invalid amount to withdraw");
		}
		while(it.hasNext())
		{
			Account acc=it.next();
			if(acc.getAccountNumber()==accountNumber)
			{
				double bal=acc.getBalance();
				bal=bal-amount;
				if(bal<0)
					throw new InsufficientFundException("Not Enough Balance");
				else {
					acc.setBalance(bal);
					flag=1;
				}
			}
		}
		if(flag==0)
			System.out.println("No Account found");
		else
			System.out.println("Withdraw successfull");
		}
	
	
	
	 public void checkBalance(int accountnumber) {
		 
		 int flag=0;
		 Iterator<Account> it=accountlist.iterator();
		 
		 while(it.hasNext()) {

			 Account acc=it.next();
			 if(acc.getAccountNumber()==accountnumber)
			 {
				 System.out.println("Balance is="+acc.getBalance());
				 flag=1;
			 }
		 }
		 if(flag==0)
			 System.out.println("Invalid Account number");
		 
	 }
	 public void changePassword(int accountNumber,String oldPassword,String newPassword) {
		 
		 Iterator<Account>it=accountlist.iterator();
		 int flag=0;
		 while(it.hasNext())
		 { Account acc=it.next();
		 	if(acc.getAccountNumber()==accountNumber)
			 {
				 if(acc.getPassword()==oldPassword)
				 {
					 acc.setPassword(newPassword);
					 System.out.println("Password changed Successfully");
				 }
				 else {
					 System.out.println("Incorrect Password");
				 }
				 flag=1;
			 }
		 }
		 if(flag==0)
		 {
			 System.out.println("Invalid account no.");
		 }
	 }
	 public List<Account> viewAllAccounts(){
		 return accountlist;
	 }
	 public void getAccountDetails(int accountNumber) {
		 Iterator<Account>it=accountlist.iterator();
		 
		 while(it.hasNext())
		 {
			 Account acc=it.next();
			 if(acc.getAccountNumber()==accountNumber)
			 {
				 System.out.println(acc);
			 }
		}
	
}
}

public class Question2 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
		Account ac1=new Account(1221,"Ana",43000);
		Account ac2=new Account(1321,"Ara",41000);
		Account ac3=new Account(1241,"ama",45000);		
		Account ac4=new Account(1211,"bhanu",33000);
		
		AccountImpl acimpl=new AccountImpl();
		acimpl.addAnAccount(ac1);
		acimpl.addAnAccount(ac2);
		acimpl.addAnAccount(ac3);
		acimpl.addAnAccount(ac4);
		
		System.out.println(acimpl.viewAllAccounts());
		System.out.println("====================");
		acimpl.checkBalance(1221);
		System.out.println("====================");
		acimpl.changePassword(1321, "Ara", "Aranta");
		System.out.println("====================");
		acimpl.changePassword(1456, "Tina","Meena");
		System.out.println("====================");
		acimpl.getAccountDetails(1211);
		System.out.println("====================");
		acimpl.withdraw(1321, 1000);
		System.out.println(acimpl.viewAllAccounts());
		}
		
		catch(InvalidAmountException e) {
			System.out.println(e.getMessage());
		}
		catch(InsufficientFundException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}

