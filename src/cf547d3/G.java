package cf547d3;

import java.io.*;
import java.util.*;

public class G {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),k=sc.nextInt();
		Integer[]degrees=new Integer[n];
		HashMap<Integer,HashSet<Integer>>tree=new HashMap<Integer,HashSet<Integer>>();
		for(int i=0;i<n;i++){
			degrees[i]=0;
			tree.put(i,new HashSet<Integer>());
		}
		for(int i=0;i<n-1;i++){
			int a=sc.nextInt()-1,b=sc.nextInt()-1;
			degrees[a]++;
			degrees[b]++;
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		Arrays.sort(degrees);
		int r=degrees[n-1-k];
		out.println(r);
		fillEdges(graph,0,-1,-1);
		// ------------------------
		out.close();
	}
	//------------------------
	private static void fillEdges(HashMap<Integer,HashSet<Integer>>graph,int a,int p,int v){
		int c=1;
		if(v==1)
			c=2;
		for(int b:graph.get(a))
			if(b!=p){
				System.out.println((a+1)+" "+(b+1));
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