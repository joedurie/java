package miscellaneous;

import java.util.*;

public class CppBad {
	private static long MOD=2147483647;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[]a=new int[n+1];
		long[][]dp=new long[n][n+1];
		long[][]dp2=new long[n][2];
		for(int i=0;i<=n;i++)
			a[i]=sc.nextInt()-1;
		dp[0][a[0]]=1;
		dp[0][a[1]]=0;
		dp2[0][0]=1;
		dp2[0][1]=0;
		for(int i=1;i<n;i++){
			for(int j=0;j<=n;j++)
		         if(works(a[i],j,a[i+1])){
		             dp[i][j]=(dp[i][j]+dp[i-1][j])%MOD;
		             dp2[i][j<a[i+1]?0:1]=(dp2[i][j<a[i+1]?0:1]+dp[i-1][j])%MOD;
		         }
		        dp[i][a[i]]=(dp[i][a[i]]+dp2[i-1][a[i+1]<a[i]?0:1])%MOD;
		        dp2[i][a[i]<a[i+1]?0:1]=(dp2[i][a[i]<a[i+1]?0:1]+dp2[i-1][a[i+1]<a[i]?0:1])%MOD;
		    }
		long ans=0;
		for(int i=0;i<n+1;i++)
			ans=(ans+dp[n-1][i])%MOD;
		System.out.println(ans);
		sc.close();
	}

	private static boolean works(int a,int b,int c){
		return (a>b)==(c>b);
	}
}
