package ProgNova2018;
import java.util.*;
public class B {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		char[][]brackets=new char[n][n];
		for(int i=0;i<n;i++){
			String s=sc.nextLine();
			for(int j=0;j<n;j++)
				brackets[i][j]=s.charAt(j);
		}
		sc.close();
		boolean possible=true;
		int currOpens=0,totCloses=0,fullCloseCols=0;
		for(int j=0;j<n;j++){
			int temp=0;
			for(int i=0;i<n;i++)
				if(brackets[i][j]==')'){
					currOpens--;
					totCloses++;
				}else
					temp++;
			if(temp==0){
				fullCloseCols++;
				totCloses-=n;
			}
			if(currOpens<0||Math.ceil(totCloses/(double)n)+fullCloseCols>(j+1)/2)
				possible=false;
			currOpens+=temp;
		}
		if(currOpens!=0)
			possible=false;
		System.out.println(possible?"Yes":"No");
	}
}