package cfed71;
import java.io.*;
import java.util.*;

public class G {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int n = sc.nextInt();
		Node[] arr = new Node[n];
		for(int i = 0; i < n; i++)
			if(sc.nextInt() == 1)
				arr[i] = new Node(null, sc.nextLine().trim().charAt(0));
			else
				arr[i] = new Node(arr[sc.nextInt() - 1], sc.nextLine().trim().charAt(0));
		int m = sc.nextInt();
		for(int i = 0; i < m; i++)
			out.println(kmp(arr[sc.nextInt()], sc.nextLine().trim().toCharArray()));
		out.close();
	}
	static int kmp(Node n, char[] s) {
		
	}
	static class Node {
		Node par;
		char c;
		public Node(Node n, char C) {
			c = C;
			par = n;
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
