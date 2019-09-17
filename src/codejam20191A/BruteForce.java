package codejam20191A;
import java.util.*;
public class BruteForce {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int q=1;q<=t;q++){
			int n=sc.nextInt(),k=sc.nextInt();
			int[]c=new int[n];
			int[]d=new int[n];
			for(int i=0;i<n;i++)
				c[i]=sc.nextInt();
			for(int i=0;i<n;i++)
				d[i]=sc.nextInt();
			int sol=0;
			for(int l=0;l<n;l++)
				for(int r=l;r<n;r++){
					int maxC=Integer.MIN_VALUE,maxD=Integer.MIN_VALUE;
					for(int i=l;i<=r;i++){
						maxC=Math.max(maxC,c[i]);
						maxD=Math.max(maxD,d[i]);
					}
					if(Math.abs(maxC-maxD)<=k)
						sol++;
				}
			System.out.println("Case #"+q+": "+sol);
		}
		sc.close();
	}
}
