package cf583d12;
import java.io.*;
import java.util.*;

public class F {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		long m = sc.nextLong();
		int n = sc.nextInt();
		TreeMap<Long, TreeSet<Integer>> a = new TreeMap<Long, TreeSet<Integer>>();
		for(int i = 0; i < n; i++)
			add(a, sc.nextLong() - 1, i);
		long[] ans = new long[n];
		TreeMap<Long, TreeSet<Integer>> b = new TreeMap<Long, TreeSet<Integer>>();
		for(int i = 0; i < n; i++) {
			long next = sc.nextLong() - 1;
			int poll;
			if((poll = poll(a, next)) == -1)
				add(b, next, i);
			else
				ans[poll] = i;
		}
		out.close();
	}
	static void add(TreeMap<Long, TreeSet<Integer>> map, long x, int ind) {
		if(!map.containsKey(x))
			map.put(x, new TreeSet<Integer>());
		map.get(x).add(ind);
	}
	static int poll(TreeMap<Long, TreeSet<Integer>> map, long x) {
		if(!map.containsKey(x)) 
			return -1;
		int ind = map.get(x).pollFirst();
		if(map.isEmpty())
			map.remove(x);
		return ind;
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