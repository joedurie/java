package BSUIR201617open;
import java.util.*;
public class H {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long[]bits=new long[20];
		for(int i=0;i<n;i++){
			int ai=sc.nextInt();
			for(int x=0;x<20;x++)
				if((ai&(1<<x))>0)
					bits[x]++;
		}
		long ans=0;
		for(int i=0;i<20;i++)
			ans+=(bits[i]*(n-bits[i])*(n-bits[i])*3+bits[i]*bits[i]*bits[i])*(1<<i);
		System.out.println(ans);
		sc.close();
	}
}
