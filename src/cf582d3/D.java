package cf582d3;
import java.io.*;
import java.util.*;

public class D {
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int[] size = new int[2000001];
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		for(int i = 0; i <= 200000; i++)
			map.put(i, 0);
		int n = sc.nextInt(), k = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			map.put(x, map.get(x) + 1);
		}
		fillSize(0);
		out.println(f(0, k));
		out.close();
	}
	public static long fillSize(int i) {
		if(i > 200000) return 0;
		size[i] = map.get(i);
		return size[i] += fillSize(2 * i) + fillSize(2 * i + 1);
	}
	public static long f(int x, int k) {
		if(size[x] < k) return Long.MAX_VALUE;
		
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
