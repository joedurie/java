package cfed68;
import java.io.*;
import java.util.*;

public class F {
	// ------------------------
	static long MOD=1000000007;
	static long[]fact=new long[1000000];
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		fillFact();
		// ------------------------
		out.close();
	}
	//------------------------
	static void fillFact(){
		fact[0]=1;
		for(long i=1;i<fact.length;i++)
			fact[(int)i]=i*fact[(int)i-1]%MOD;
	}
	static long choose(int n,int k){
		if(k>n)return 0;
		return fact[n]*modInv(fact[k])%MOD*modInv(fact[n-k]);
	}
	private static long modInv(long x){
		return pow(x,MOD-2);
	}
	private static long pow(long a,long p){
		if(p==0)
			return 1;
		long x=pow(a,p/2);
		return x*x%MOD*(p%2==1?a:1)%MOD;
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
		int nextInt() {
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
