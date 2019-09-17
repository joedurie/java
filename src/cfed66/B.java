package cfed66;
import java.io.*;
import java.util.*;

public class B {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int l=sc.nextInt();
		Stack<Long>loops=new Stack<Long>();
		long ans=0,currProd=1;
		for(int i=0;i<l;i++){
			String s=sc.nextLine();
			if(s.substring(0,3).equals("for")){
				long n=Long.parseLong(s.substring(4));
				loops.push(n);
				if(n<=Long.MAX_VALUE/currProd)
					currProd*=n;
				else
					currProd=Long.MAX_VALUE;
			}else if(s.equals("add")&&currProd!=Long.MAX_VALUE&&currProd<=Long.MAX_VALUE-ans)
				ans+=currProd;
			else if(s.equals("add"))
				ans=Long.MAX_VALUE/100;
			else if(currProd==Long.MAX_VALUE)
				ans=Long.MAX_VALUE/100;
			else if(currProd!=Long.MAX_VALUE)
				currProd/=loops.pop();
			else
		}
		out.println(ans<0||ans>=(1L<<32)?"OVERFLOW!!!":ans);
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
