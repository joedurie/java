package cfed58;
import java.io.*;
import java.util.*;

public class C {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int t=sc.nextInt();
		for(int h=0;h<t;h++){
			int n=sc.nextInt();
			int[]dp=new int[20000];
			HashMap<Integer,Integer>sets=new HashMap<Integer,HashSet<Integer>>();
			for(int i=0;i<n;i++){
				int l=sc.nextInt(),r=sc.nextInt();
				dp[l]++;
				dp[r]--;
				if(!pairs.containsKey(l))
					pairs.put(l, new HashSet<Integer>());
				pairs.get(l).add(r);
			}
			for(int i=1;i<dp.length;i++){
				dp[i]+=dp[i-1];
				if(dp[i])
			
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