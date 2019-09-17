package miscellaneous;
import java.util.*;
public class ChefCCYL {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int h=0;h<t;h++){
			int n=sc.nextInt(),q=sc.nextInt();
			long[][]pSum=new long[n][];
			for(int i=0;i<n;i++){
				int l=sc.nextInt();
				pSum[i]=new long[l];
				pSum[i][0]=sc.nextInt();
				for(int j=1;j<l;j++)
					pSum[i][j]=sc.nextInt()+pSum[i][j-1];
			}
			long[]pSumBig=new long[2*n];
			int[][]v=new int[n][2];
			for(int i=0;i<n;i++){
				int v1=sc.nextInt()-1,v2=sc.nextInt()-1;
				v[i][1]=v1;
				v[(i+1)%n][0]=v2;
				pSumBig[2*i+1]=sc.nextInt()+pSumBig[2*i];
			}
			for(int i=0;i<n;i++)
				pSumBig[2*i]=minDist(pSum[i],v[i][0],v[i][1]);
			for(int i=1;i<2*n;i++)
				pSumBig[i]+=pSumBig[i-1];
			for(int i=0;i<q;i++){
				int v1=sc.nextInt()-1,c1=sc.nextInt()-1;
				int v2=sc.nextInt()-1,c2=sc.nextInt()-1;
				long min=Integer.MAX_VALUE;
				for(int a=0;a<2;a++)
					for(int b=0;b<2;b++){
						long dist=minDist(pSum[c1],v1,v[c1][a])
								+minDist(pSumBig,2*c1+a,2*c2+b)
								+minDist(pSum[c2],v[c2][b],v2);
						if(dist<min)
							min=dist;
					}
				System.out.println(min);
			}
		}
		sc.close();
	}
	public static long minDist(long[]prefixSums,int v1,int v2){
		int l=prefixSums.length;
		long dist=prefixSums[(v2-1+l)%l]-prefixSums[(v1-1+l)%l];
		if(dist<0)
			dist+=prefixSums[l-1];
		return Math.min(dist,prefixSums[l-1]-dist);
	}
}