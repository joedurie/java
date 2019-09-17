package cf539d1;
import java.io.*;
import java.util.*;

public class D{
	// ------------------------
	static long[]f;
	static long MOD=1000000007;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		long n=sc.nextLong(),m=sc.nextLong();
		f=new long[1000000];
		fillFact();
		long ans=0;
		for(int i=0;i<=Math.min(n-2,m-1);i++){
			ans=(ans+(pow(m,n-2-i)*C(m-1,i)%MOD*C(n-2,i)%MOD*f[(int)n-1]%MOD*fInv(i+1)%MOD))%MOD;
			out.println(pow(m,n-2-i)+" "+C(m-1,i)+" "+C(n-2,i)+" "+f[(int)n-1]*fInv(i+1)%MOD);
		}
		out.println(ans);
		// ------------------------
		out.close();
	}
	//------------------------
	static long C(long n,int i){
		return f[(int)n]*fInv(i)%MOD*fInv((int)n-i)%MOD;
	}
	static void fillFact(){
		f[0]=1;
		for(int i=1;i<f.length;i++)
			f[i]=((long)i*f[i-1])%MOD;
	}
	static long fInv(int i){
		return pow(f[i],MOD-2);
	}
	static long pow(long a,long b){
		if(b==0)
			return 1;
		long p=pow(a,b/2);
		return ((p*p)%MOD*(b%2==1?a:1))%MOD;
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
