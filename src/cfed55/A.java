package cfed55;
import java.io.*;
import java.util.*;

public class A {
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int t=sc.nextInt();
		for(int w=0;w<t;w++){
			int n=sc.nextInt()-1,s=sc.nextInt()-1,e=sc.nextInt()-1,d=sc.nextInt();
			if((s-e)%d==0){
				System.out.println(((int)Math.abs(s-e))/d);
				break;
			}
			int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE;
			if(e%d==0)
				a=(int)Math.ceil(s/(double)d)+e/d;
			if((n-e)%d==0)
				b=(int)Math.ceil((n-s)/(double)d)+(n-e)/d;
			if(a==Integer.MAX_VALUE&&b==Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(Math.min(a,b));
				
		}
		// ------------------------
		out.close();
	}
	//------------------------
	
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
