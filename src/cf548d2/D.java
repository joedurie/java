package cf548d2;

import java.io.*;
import java.util.*;

public class D{
	// ------------------------
	private static long MOD=1000000007;
	private static int m;
	private static ArrayList<Integer>primes=new ArrayList<Integer>();
	private static HashMap<Integer,ArrayList<Integer>>factors=new HashMap<Integer,ArrayList<Integer>>();
	private static long[]p;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		m=(int) sc.nextInt();
		for(int i=2;i<=m;i++){
			factors.put(i,new ArrayList<Integer>());
			int ind=0;
			while(ind<primes.size()&&primes.get(ind)<=Math.ceil(Math.sqrt(i))){
				if(i%primes.get(ind)==0){
					if(!factors.get(i).contains(primes.get(ind)))
						factors.get(i).add(primes.get(ind));
					for(int j:factors.get(i/primes.get(ind)))
						if(!factors.get(i).contains(j))
							factors.get(i).add(j);
				}
				ind++;
			}
			if(factors.get(i).isEmpty()){
				primes.add(i);
				factors.get(i).add(i);
			}
		}
		for(int i=3;i<=15;i++)
			System.out.println(i+" "+factors.get(i));
		p=new long[m+1];
		for(int i=2;i<=m;i++){
			for(int j=1;j<Math.ceil(Math.pow(2,factors.get(i).size()));j++){
				long x=0,prod=1;
				for(int l=0;l<factors.get(i).size();l++)
					if((1<<l&j)>0){
						x++;
						prod*=factors.get(i).get(l);
					}
				p[i]+=(x%2==1?1:-1)*(m/prod);
			}
		}
		Fraction[]ev=new Fraction[m+1];
		Fraction ans=new Fraction(1,m);
		for(int i=2;i<=m;i++){
			ev[i]=e(i);
			if(!primes.contains(i)){
				Fraction num=new Fraction(0,1);
				long den=0;
				for(int j=1;j<Math.ceil(Math.pow(2,factors.get(i).size()));j++){
					int temp=1;
					for(int l=0;l<factors.get(i).size();l++)
						if((1<<l&j)>0){
							temp*=factors.get(i).get(l);
						}
					System.out.println(i+" "+temp);
					num=num.add(ev[temp].multiply(new Fraction(p[temp],1)));
				}
				ev[i]=ev[i].add(num.multiply(new Fraction(1,m)));
			}
			ans=ans.add(ev[i].multiply(new Fraction(1,m)));
		}
		for(int i=1;i<=m;i++)
			System.out.println(ev[i]);
		System.out.println(ans);
		System.out.println((ans.num*inv(ans.den))%MOD);
		// ------------------------
		out.close();
	}
	//------------------------
	static long inv(long i){
		return pow(i,MOD-2);
	}
	private static long pow(long x,long p){
		if(p==0)
			return 1;
		long a=pow(x,p/2);
		return (((a*a)%MOD)*(p%2==1?x:1))%MOD;
	}
	static Fraction e(int i){
		return new Fraction(p[i]*(2*m-p[i]),(m-p[i]));
	}
	static long gcd(long a,long b){
		return b==0?a:gcd(b,a%b);
	}
	public static class Fraction{
		long num;
		long den;
		public Fraction(long n,long d){
			num=n;
			den=d;
			long g=gcd(num,den);
			num/=g;
			den/=g;
		}
		public String toString(){
			return num+"/"+den;
		}
		public Fraction add(Fraction other){
			return new Fraction(num*other.den+den*other.num,den*other.den);
		}
		public Fraction multiply(Fraction other){
			return new Fraction(num*other.num,den*other.den);
		}
	}
	public static PrintWriter out;
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;
		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		long nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
