
public class Account {
	private int accountNumber;
	private String password;
	private double balance;
	public Account(int accountNumber, String password, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.password = password;
		this.balance = balance;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", password=" + password + ", balance=" + balance + "]\n";
	}
	
	
}
