//Calculate Cricket Innings
import java.util.*;
public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Random rd=new Random();
		
		int run[][]=new int[5][6];
		int totalScore=0;
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<6;j++) {
				run[i][j]=(int)(Math.random()*10)%7;
				totalScore+=run[i][j];
			}
		}
		
		
		System.out.println("1. Total runs scored "+totalScore);
		System.out.println("----------------------------------");
		int scores[]=new int[7];
		
		for(int i=0;i<5;i++){
			for(int j=0;j<6;j++){
			if(run[i][j]==0)
				scores[0]+=1;
			
			else if(run[i][j]==1)
				scores[1]+=1;
			
			else if(run[i][j]==2)
				scores[2]+=1;
			
			else if(run[i][j]==3)
				scores[3]+=1;
			
			else if(run[i][j]==4)
				scores[4]+=1;
			
			else if(run[i][j]==5)
				scores[5]+=1;
			
			else 
				scores[6]+=1;
		}
		}
		
		System.out.println("2. Number of 0s, 1s, 2s, 3s, 4s and 6s. respectively are:"+
		scores[0]+','+scores[1]+','+scores[2]+','+scores[3]+','+scores[4]+','+scores[6]);
		System.out.println("----------------------------------");
		
		double strikeRate=(double)totalScore/30;
		System.out.println("3. Strike Rate: "+ (double) Math.round(strikeRate*100)/100);
		
		
	}

}
