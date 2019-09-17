package northwesticpc2017;
import java.io.*;
import java.util.*;

public class D {
	static ArrayList<HashSet<Edge>> tree = new ArrayList<HashSet<Edge>>();
	static boolean[] good;
	static int[] goodChild;
	static TreeSet<Integer> gSet = new TreeSet<Integer>();
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = sc.nextInt();
		for(int i = 0; i < n; i++)
			tree.add(new HashSet<Edge>());
		for(int i = 0; i < n - 1; i++) {
			int u = sc.nextInt() - 1, v = sc.nextInt() - 1, c = sc.nextInt();
			tree.get(u).add(new Edge(v, c));
			tree.get(v).add(new Edge(u, c));
		}
		good = new boolean[n];
		goodChild = new int[n];
		for(int i = 0; i < n; i++) {
			good[i] = true;
			goodChild[i] = -1;
		}
		fillGood(0, -1, -1);
		propagate(0, -1);
		out.println(gSet.size());
		for(int i : gSet)
			out.println(i);
		out.close();
	}
	public static boolean fillGood(int i, int p, int c) {
		HashMap<Integer, Integer> colMap = new HashMap<Integer, Integer>();
		for(Edge j : tree.get(i))
			colMap.put(j.c, colMap.containsKey(j.c) ? colMap.get(j.c) + 1 : 1);
		boolean propagateUp = false;
		if(c != -1 && colMap.get(c) > 1)
			propagateUp = true;
		for(Edge j : tree.get(i)) 
			if(j.v != p) {
				if(fillGood(j.v, i, j.c)) {
					setGC(i, j.v);
					propagateUp = true;
				}
				if(colMap.get(j.c) > 1)
					setGC(j.v, -2);
			}
		return propagateUp;
	}
	public static void propagate(int i, int p) {
		if(goodChild[i] == -2) return;
		if(goodChild[i] != -1) {
			propagate(goodChild[i], i);
			return;
		}
		gSet.add(i + 1);
		for(Edge j : tree.get(i))
			if(j.v != p)
				propagate(j.v, i);
	}
	public static void setGC(int i, int x) {
		if(goodChild[i] == -1)
			goodChild[i] = x;
		else
			goodChild[i] = -2;
	}
	static class Edge {
		int v, c;
		public Edge(int V, int C) {
			v = V;
			c = C;
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
