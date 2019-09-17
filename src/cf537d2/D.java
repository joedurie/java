package cf537d2;
import java.util.*;
public class D {
	private static final long MOD=1000000007;
	private static HashMap<Character,Integer>nums=new HashMap<Character,Integer>();
	private static long[]factorial;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[]s=sc.nextLine().toCharArray();
		factorial=new long[s.length+1];
		factorial[0]=1;
		for(int i=0;i<factorial.length;i++)
			factorial[i]=(i*factorial[i-1])%MOD;
		for(int i=0;i<s.length;i++)
			if(nums.containsKey(s[i]))
				nums.put(s[i],nums.get(s[i])+1);
			else
				nums.put(s[i],1);
		int q=sc.nextInt();
		for(int i=0;i<q;i++){
			char c1=s[sc.nextInt()-1],c2=s[sc.nextInt()-1];
			System.out.println( ((2 * choose(s.length/2,nums.get(c1)+nums.get(c2)))%MOD * 
					(choose(nums.get(c1)+nums.get(c2),nums.get(c1)) * arrangements(c1,c2)) % MOD)%MOD);
		}
		sc.close();
	}
	public static long arrangements(char c1,char c2){
		
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
	public static long pow(long a,long p){
		if(p==1)
			return a;
		long s=pow(a,p/2);
		return (((s*s)%MOD)*(p%2==1?a:1))%MOD;
	}
}
