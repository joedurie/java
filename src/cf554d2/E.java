package cf554d2;
import java.io.*;
import java.util.*;

public class E{
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt()-1;
		int[]bp=new int[n];
		int[]cp=new int[n];
		HashMap<Integer,TreeSet<Integer>>bMap=new HashMap<Integer,TreeSet<Integer>>();
		for(int i=0;i<n;i++)
			bp[i]=sc.nextInt();
		for(int i=0;i<n;i++)
			cp[i]=sc.nextInt();
		boolean ok=true;
		for(int i=0;i<n;i++)
			if(bp[i]>cp[i])
				ok=false;
		if(!ok)
			System.out.println(-1);
		else{
			
		}
		// ------------------------
		out.close();
	}
	//------------------------
	public class BS{
		int
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
