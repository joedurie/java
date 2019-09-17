package cf558d2;
import java.io.*;
import java.util.*;

public class D {
	// ------------------------
	static class Node{
		char val;
		HashSet<Node>children;
		HashSet<Character>childSet;
		public Node(char c){
			val=c;
		}
		void add(char c){
			if(!childSet.contains(c)){
				children.add(new Node(c));
				childSet.add(c);
			}
		}
	}
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		char[]c=sc.nextLine().toCharArray();
		Node root=new Node('$');
		
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
