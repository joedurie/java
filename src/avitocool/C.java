package avitocool;
import java.util.*;
public class C {
	private static final long MOD=998244353;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		long n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
		sc.close();
		System.out.println(choose(n-1,Math.min(k,n-1-k))*(m*Math.max(1,k*(m-1))%MOD)%MOD);
	}
	public static long choose(long n,long r){
		long num=1;
		for(long i=n;i>n-r;i--)
			num=(num*i)%MOD;
		long denom=1;
		for(long i=2;i<=r;i++)
			denom=(denom*i)%MOD;
		return (num*pow(denom,MOD-2)%MOD);
	}
	public static long pow(long a,long b){
		if(b<2)
			return (long)Math.pow(a, b);
		long s=pow(a,b/2);
		return (((s*s)%MOD)*(b%2==1?a:1))%MOD;
	}
}