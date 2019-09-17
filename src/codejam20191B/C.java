package codejam20191B;
import java.util.*;
public class C {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(),w=sc.nextInt();
		for(int cs=1;cs<=t;cs++){
			System.out.println(50);
			System.out.flush();
			long resp1=sc.nextLong();
			long r1=resp1/p(50);
			resp1-=r1*p(50);
			long r2=resp1/p(25);
			resp1-=r2*p(25);
			System.out.println(150);
			System.out.flush();
			long resp2=sc.nextLong();
			long r3=resp2/p(50);
			resp2-=r3*p(50);
			long r4=resp2/p(37);
			resp2-=r4*p(37);
			resp1-=r3*p(16);
			resp1-=r4*p(12);
			resp1/=p(8);
			resp2/=p(25);
			long r5=(resp2-resp1)/28;
			long r6=resp1-4*r5;
			System.out.println(r1+" "+r2+" "+r3+" "+r4+" "+r5+" "+r6);
			System.out.flush();
			if(sc.nextInt()!=1)
				break;
		}
		sc.close();
	}
	private static long p(int a){
		return (long)Math.pow(2,a%63);
	}
}
