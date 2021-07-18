import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import MyExceptions.EmployeeAlreadyExistsException;


/*
 * create or replace function withdrawbal(x in number,y in number) return number

  2      as
  3      totalbalance number;
  4      begin
  5      select balance into totalbalance from accountjava where accno=x;
  6      return totalbalance-y;
  7      end;
  8      /
 * 
 */

/*
 * 
 * *  create or replace function checkbalance(x number) return number
 */
class AccountDaoImpl implements AccountDao{
	 
	 List<Account>accountlist=new ArrayList<>();
	

	
	static Connection conn;
	static Scanner sc=new Scanner(System.in);
	
	public void addAnAccount(Account account) {
		
		try {
		int accNo=account.getAccountNumber();
		String accHolder= account.getPassword();
		//sc.hasNextLine();
		double balance=account.getBalance();
		
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from accountjava");
		
		while(rs.next())
		{
			if(rs.getInt(1)==accNo)
			{
				throw new EmployeeAlreadyExistsException("Account Already created");
			}
		}
		
		PreparedStatement pst=conn.prepareStatement("insert into accountjava values(?,?,?)");
		pst.setInt(1,accNo);
		pst.setString(2,accHolder);
		pst.setDouble(3, balance);
		
		int row=pst.executeUpdate();
		
		if(row>0)
		{
			System.out.println("Rows Entered="+row);
			accountlist.add(account);
		}
		else {
			System.out.println("No row entered");
		}
		
		
		
		rs.close();
		st.close();
	}
	
	catch(EmployeeAlreadyExistsException e)
	{
		System.out.println(e.getMessage());
	}
	catch(SQLException e)
	{
		System.out.println(e.getMessage());
	}

}
	
	public void withdraw(int accountNumber,double amount) throws InvalidAmountException,InsufficientFundException {
		
		try {

			CallableStatement cst=conn.prepareCall("{ ? = call withdrawbal(?,?)}");
			
			cst.setInt(2, accountNumber);
			cst.setDouble(3, amount);
			
			cst.registerOutParameter(1, Types.DOUBLE);
			
			
	
	
			
			cst.execute();
			
			double bal=cst.getDouble(1);
			
			
			System.out.println("balance="+bal);
			
			cst.close();
			conn.close();
		
	}	
	catch(SQLException e)
	{
		System.out.println(e.getMessage());
	}
		
}
	
	
	 public void checkBalance(int accountnumber) {
	
		 System.out.println("hello1");
		 try {
			
			 Statement st= conn.createStatement();
			 System.out.println("hello");
			 ResultSet rs=st.executeQuery("select balance from accountjava where accno="+accountnumber);
			// System.out.println(rs.next()+"hello3");
			 while(rs.next())
				{
					double i=rs.getDouble(1);
				
					
					System.out.println("First value"+i);
					
					
				}
					rs.close();
					st.close();
				System.out.println("Execution completed");
			 
		 }
		 catch(SQLException e)
			{
				System.out.println(e.getMessage());
			}
	 }
	 
	 public List<Account> viewAllAccounts(){
		 List<Account>account=new ArrayList<>();
		 try {
			 
		 Statement st=conn.createStatement();
		 ResultSet rs=st.executeQuery("select * from accountjava");
		 
		 while(rs.next())
		 {
			 Account ac=new Account(rs.getInt(1),rs.getString(2),rs.getDouble(3));
			 if(!account.contains(ac))
			 account.add(ac);
		 }
		 
		 rs.close();
		 st.close();
		 }
		 catch(SQLException e)
		 {
			 System.out.println(e.getMessage());
		 }
		 
		 finally{
			 return account;
		 }
	 }
	 public void getAccountDetails(int accountNumber) {
		 
		 try {
			 System.out.println("Hello again");
			 Statement st= conn.createStatement();
				ResultSet rs=st.executeQuery("select * from  accountJava where accno="+accountNumber);
				
				//Statement st = conn.createStatement();
				//ResultSet rs = st.executeQuery("select * from "+tableName ); //sql query here
				//System.out.println(rs.next());
				while(rs.next())
				{
					System.out.println("hello three");
					int i=rs.getInt(1);
					String s1=rs.getString(2);
					
					Double s2=rs.getDouble(3);
					
					System.out.println("Account Number"+i);
					System.out.println("Password"+s1);
					System.out.println("Balance"+s2);
					System.out.println("========================");
					
				}
					rs.close();
					st.close();
				System.out.println("Execution completed");
			 
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println(e.getMessage());
		 }
		 
	
}
	 
	 public void changePassword(int accountNumber,String oldPassword,String newPassword) {
		 try {
		 Statement st=conn.createStatement();
		 ResultSet rs=st.executeQuery(" Select * from accountjava where accno="+accountNumber
 				+ " and password = '"+oldPassword+"'");
		
		
		 while(rs.next())
		 {
			 String pass=rs.getString(2);
			 System.out.println(pass);
			 System.out.println(oldPassword);
			
				 PreparedStatement pst=conn.prepareStatement("update accountjava set password=? where accno=?");
				 pst.setString(1, newPassword);
				 pst.setInt(2, accountNumber);
				 int row = pst.executeUpdate();
				if(row==1)
				 System.out.println("Password Changed sucessfully");
				else
					System.out.println("Invalid Operation");
				
		 }
		 rs.close();
		 st.close();
		 }
		 
		 catch(SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 }
}

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			String url=	"jdbc:oracle:thin:@LAPTOP-27SUD8SK:1521:XE";
			String user="hr";
			String password="hr";
			System.out.println("Hello");
			AccountDaoImpl.conn=DriverManager.getConnection(url,user,password);
			
			/*Account acc=new Account(1434,"dgaa",13826);
			ad.addAnAccount(acc);
			//ad.withdraw(1221,1000);
			System.out.println("=====================");
			ad.checkBalance(1231);
			System.out.println("=====================");
			System.out.println(ad.viewAllAccounts());
			Account acc1=new Account(1234,"tanu",15226);
			ad.addAnAccount(acc1);
			System.out.println("=====================");
			System.out.println(ad.viewAllAccounts());
			System.out.println("=====================");
			ad.getAccountDetails(1231);
			System.out.println("=====================");
			ad.changePassword(1231, "Aranta", "Ara");
			System.out.println(ad.viewAllAccounts());*/
			AccountDaoImpl ad=new AccountDaoImpl();
			Scanner scan=new Scanner(System.in);
			
			int ch;
			do {
			System.out.println("1. Addaccount /n 2. View Accounts/n 3. Withdraw amount/n 4. change password/n 5. Check Account Details /n 6. Check balance/n 7. exit");
			
			ch=scan.nextInt();
			switch(ch) {
			
			case 1:
				System.out.println("Add account no");
				int accnos=scan.nextInt();
				System.out.println("Add password");
				String pass=scan.next();
				System.out.println("Add balance");
				double bal=scan.nextDouble();
				Account ac=new Account(accnos,pass,bal);
				ad.addAnAccount(ac);
				System.out.println("=========================");
				break;
			case 2:
				 System.out.println(ad.viewAllAccounts());
				 System.out.println("=========================");
				 break;
			case 3:
				System.out.println("Account no.");
				int accnt=scan.nextInt();
				System.out.println("Amount to be withdrawn");
				double amt=scan.nextDouble();
				ad.withdraw(accnt, amt);
				break;
			case 4:
				System.out.println("Account no.");
				int accnts=scan.nextInt();
				System.out.println("Old password");
				String oldpass=scan.next();
				System.out.println("new password");
				String newpass=scan.next();
				ad.changePassword(accnts, oldpass, newpass);
				System.out.println("=========================");
				break;
			case 5:
				System.out.println("Account no.");
				int accntno=scan.nextInt();
				ad.getAccountDetails(accntno);
				System.out.println("=========================");
				break;
			case 6:
				System.out.println("Account no.");
				int accntnos=scan.nextInt();
				ad.getAccountDetails(accntnos);
				System.out.println("=========================");
				break;
			case 7:
				System.out.println("Thank you!");
				break;
			default:
				System.out.println("No such choice exist");
				
			}
			
		}while(ch!=7);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}
