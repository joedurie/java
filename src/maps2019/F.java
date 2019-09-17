package maps2019;
import java.util.*;
public class F {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int q=sc.nextInt();
		for(int w=0;w<q;w++){
			double r=sc.nextDouble();
			int n=sc.nextInt();
			double ans=0;
			double num=1;
			for(int i=0;i<n;i++){
				ans+=num*Math.PI*r*r;
				if(num==1)
					num=4;
				else
					num*=3;
				r/=2;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
