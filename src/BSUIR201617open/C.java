package BSUIR201617open;
import java.util.*;
public class C {
	static long[][]dp;
	static char[]s;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt();
		sc.nextLine();
		s=sc.nextLine().toCharArray();
		long[][]dp=new long[n][k];
		System.out.println(dp(n-1,0));
	}
	private static long dp(int n,int k){
		if(dp[n][k]>0)
			return dp[n][k];
		if(s[n]=='?')
			for(int d=0;d<10;d++){
				int
			}
	}
}
