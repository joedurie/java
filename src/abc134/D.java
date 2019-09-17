package abc134;
import java.io.*;
import java.util.*;

public class D {
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		int[]a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int[]x=new int[n];
		int m=0;
		HashSet<Integer>set=new HashSet<Integer>();
		for(int i=n-1;i>=0;i--){
			if((a[i]+x[i])%2==1){
				m++;
				set.add(i+1);
				addTo(x,i+1);
			}
		}
		System.out.println(m);
		for(int i:set)
			System.out.print(i+" ");
		// ------------------------
		out.close();
	}
	//------------------------
	private static void addTo(int[]x,int n){
		for(int i=1;i<=Math.sqrt(n);i++)
			if(n%i==0){
				x[i-1]++;
				if(i!=n/i)
				x[n/i-1]++;
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
