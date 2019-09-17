package icpcpractice2018;
import java.util.*;
public class BestRationalApprox {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int i=1;i<=p;i++){
			sc.nextInt();
			int m=sc.nextInt();
			double x=sc.nextDouble();
			double min=1;
			int minN=-1,minD=-1;
			for(double d=1;d<=m;d++){
				double n=Math.round(d*x);
				if(Math.abs(n/d-x)<min){
					min=Math.abs(n/d-x);
					minN=(int)n;
					minD=(int)d;
				}
			}
			System.out.println(i+" "+minN+"/"+minD);
		}
		sc.close();
	}
}