
//let the overs in one inning ==3
//so balls per inning==3*6=18
import java.util.*;
public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int scores[][]=new int[5][18];
		long totalScore=0;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<18;j++)
			{
				scores[i][j]=(int)((Math.random()*10)%7);
				totalScore+=scores[i][j];
			}
			
		}
		double averageScore=(double)Math.round((double)totalScore/90*100)/100;
		
        int run[]=new int[7];
		
		for(int i=0;i<5;i++){
			for(int j=0;j<18;j++){
			if(scores[i][j]==0)
				run[0]+=1;
			
			else if(scores[i][j]==1)
			    run[1]+=1;
			
			else if(scores[i][j]==2)
				run[2]+=1;
			
			else if(scores[i][j]==3)
				run[3]+=1;
			
			else if(scores[i][j]==4)
				run[4]+=1;
			
			else if(scores[i][j]==5)
				run[5]+=1;
			
			else 
				run[6]+=1;
		}
		}
		
		System.out.println("1. Average score of last 5 matches "+averageScore);
		System.out.println("2. Total runs scored "+totalScore);
		System.out.println("----------------------------------");
		System.out.println("3. Number of 0s, 1s, 2s, 3s, 4s and 6s. respectively are:"+
		run[0]+','+run[1]+','+run[2]+','+run[3]+','+run[4]+','+run[6]);
		System.out.println("----------------------------------");
		System.out.println("Strike rate "+ averageScore );
		
	}

}
