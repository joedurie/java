package cf583d12;
import java.io.*;
import java.util.*;

public class A {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		long a = sc.nextLong(), b = sc.nextLong(), c = 5 * sc.nextLong();
		long x = c, ans = a % b;
		while(x <= a) {
			ans = Math.min(ans, (a % x) % b);
			x += c;
		}
		System.out.println(ans);
		out.close();
	}
	public static PrintWriter out  = new PrintWriter(new BufferedOutputStream(System.out));
	public static class MyScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String next() {
			while (st == null || !st.hasMoreElements())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
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