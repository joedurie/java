package cfhello2019;
import java.util.*;

import cfhello2019.D.Fraction;
public class D2 {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		long v=sc.nextLong(),k=sc.nextLong();
		sc.close();
		LinkedList<Long>facts=new LinkedList<Long>();
		for(long i=(long)Math.floor(Math.sqrt(v));i>0;i--)
			if(v%i==0){
				facts.addFirst(i);
				if(v/i!=i)
					facts.addLast(v/i);
			}
		long[]factArr=new long[facts.size()];
		HashMap<Integer,HashSet<Integer>>map=new HashMap<Integer,HashSet<Integer>>();
		for(int i=0;i<factArr.length;i++){
			factArr[i]=facts.removeFirst();
			map.put(i,new HashSet<Integer>());
			for(int j=0;j<=i;j++)
				if(factArr[i]%factArr[j]==0)
					map.get(i).add(j);
		}
		Fraction[]probs=new Fraction[factArr.length];
		for(int i=0;i<factArr.length;i++)
			probs[i]=new Fraction(1,factArr.length);
		for(int i=1;i<k;i++){
			Fraction[]temp=new Fraction[factArr.length];
		}
	}
	public static class Fraction{
		long num;
		long denom;
		long mod=1000000007;
		public Fraction(long n,long d){
			num=n;
			denom=d;
			simplify();
		}
		public Fraction add(Fraction f){
			return new Fraction(num*f.denom+denom*f.num,denom*f.denom);
		}
		public Fraction mult(Fraction f){
			return new Fraction(num*f.num,denom*f.denom);
		}
		public void simplify(){
			if(num==0)
				denom=1;
			else{
				long a=Math.max(num,denom),b=Math.min(num,denom);
				while(a!=b&&a%b!=0){
					long temp=Math.max(b, a-b);
					b=Math.min(b,a-b);
					a=temp;
				}
				num/=b;
				denom/=b;
			}
		}
		public long modForm(){
			return num*pow(denom,mod-2)%mod;
		}
		public String toString(){
			return num+"/"+denom;
		}
		public long pow(long a,long p){
			if(p==1)
				return a;
			long half=pow(a,p/2);
			return ((half*half%mod)*(p%2==1?a:1))%mod;
		}
	}
}
