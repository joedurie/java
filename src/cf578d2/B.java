package cf578d2;
import java.io.*;
import java.util.*;

public class B {
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		long t = sc.nextLong();
		for(long w = 0; w < t; w++) {
			long n = sc.nextLong(), m = sc.nextLong(), k = sc.nextLong();
			System.out.println(n+" "+m+" "+k);
			boolean b = true;
			long last = sc.nextLong();
			for(long i = 0; i < n - 1; i++) {
				long next = sc.nextLong();
				long del = last - Math.max(0L, next - k);
				if(m + del >= 0)
					m += del;
				else {
					b = false; 
				}
				last = next;
			}
			System.out.println(b ? "YES" : "NO");
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
