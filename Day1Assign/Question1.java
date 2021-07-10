import java.util.*;
public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		int units;
		System.out.println("Enter your units of consumption");
		units=sc.nextInt();
		
		double bill;
		
		if(units<=100) {
			bill=units*1.20;
		}
		
		else if(units>100 && units<=300)
		{
			bill=100*1.20+(units-100)*2;
		}
		else
		{
			bill=100*1.20+200*2+(units-300)*3;
		}
		
		System.out.println("Total bill: "+bill);
	}

}
