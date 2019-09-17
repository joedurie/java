package cf540d3;
import java.util.*;
public class D {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int[]a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		sc.close();
		int[] sSum=new int[n];
		sSum[n-1]=a[n-1];
		for(int i=n-2;i>=0;i--)
			sSum[i]=a[i]+sSum[i+1];
		int days=Integer.MAX_VALUE;
		for(int k=1;k<=n;k++)
			days=Math.min(days,d(k,a,sSum,m,n));
		System.out.println(days==Integer.MAX_VALUE?-1:days);
	}
	private static int d(int k,int[]a,int[]s,int m,int n){
		int days=0;
		for(int i=0;i<n;i++)
			sum+=Math.max(0,a[i]-i%k);
		return sum>=m;
	}
}
