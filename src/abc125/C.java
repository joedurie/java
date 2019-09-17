package abc125;
import java.io.*;
import java.util.*;

public class C {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		long[]a=new long[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextLong();
		HashSet<Long>set=factors(a[0]);
		set.addAll(factors(a[1]));
		long max=1;
		for(long x:set){
			int ct=0;
			for(int i=0;i<n;i++)
				if(a[i]%x==0)
					ct++;
			if(ct>=n-1)
				max=Math.max(x,max);
		}
		System.out.println(max);
		// ------------------------
		out.close();
	}
	//------------------------
	private static HashSet<Long>factors(long a){
		HashSet<Long>f=new HashSet<Long>();
		for(long i=1;i<=Math.ceil(Math.sqrt(a));i++)
			if(a%i==0){
				f.add(i);
				f.add(a/i);
			}
		return f;
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
