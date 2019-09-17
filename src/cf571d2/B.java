package cf571d2;
import java.io.*;
import java.util.*;

public class B{
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		long n=sc.nextInt()+1,m=sc.nextInt()+1;
		System.out.println(Math.max(x(n,m),x(m,n)));
		// ------------------------
		out.close();
	}
	//------------------------
	public static long x(long n,long m){
		long ans=(n/3)*(m/2);
		if(n%3==2&&m%3==2&&n%2==1&&m%2==1)
			ans++;
		if(n%3==2){
			ans+=m/3;
			n-=2;
		}else if(n%3==1&&2*(m/3)>m/2){
			ans+=2*(m/3)-m/2;
			n-=4;
			if(m%3==2)
				ans++;
		}
		if(m%2==1)
			ans+=n/2-n/3;
		return ans;
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
