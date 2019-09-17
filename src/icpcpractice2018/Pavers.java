package icpcpractice2018;
import java.util.Scanner;
public class Pavers {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.close();
		int[][]dp=new int[n+1][4];
		int[][]dp2=new int[n+1][4];
		dp[0][0]=1;
		for(int i=0;i<dp.length;i++){
			add(dp,i,dp,i-1,2,new int[]{0,2,1,0});
			add(dp,i,dp,i-2,3,new int[]{0,2,2,2});
			add(dp,i,dp2,i-2,4,new int[]{0,2,2,2});
			add(dp2,i,dp,i,1,new int[]{0,1,0,0});
			add(dp2,i,dp,i-1,1,new int[]{0,0,0,1});
			add(dp2,i,dp2,i-1,1,new int[]{0,0,1,0});
		}
		for(int i:dp[n])
			System.out.print(i+" ");
	}
	public static void add(int[][]dpA,int iA,int[][]dpB,int iB,int f,int[]arr){
		if(iB>=0)
			for(int j=0;j<dpA[iA].length;j++)
				dpA[iA][j]+=f*dpB[iB][j]+arr[j]*dpB[iB][0];
	}
}