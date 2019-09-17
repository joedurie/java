package cf557d1;
import java.io.*;
import java.util.*;

public class A{
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),k=sc.nextInt();
		int[]query=new int[n];
		for(int i=0;i<n;i++)
			query[i]=-1;
		for(int i=0;i<k;i++){
			int x=sc.nextInt()-1;
			if(query[x]==-1)
				query[x]=i;
			else
				query[x]=-2;
		}
		long[]pSum=new long[k+1];
		int ok=0;
		for(int i=0;i<n;i++)
			if(query[i]!=-2){
				pSum[query[i]+1]++;
				ok++;
			}
		for(int i=1;i<=k;i++)
			pSum[i]+=pSum[i-1];
		long ans=0;
		for(int i=0;i<n;i++)
			if(query[i]>0)
				ans+=pSum[query[i]+1]-1;
			else if(query[i]==-1)
				ans+=ok;
		for(long i:pSum)
			System.out.println(i);
		System.out.println();
		for(int i:query)
			System.out.println(i);
		System.out.println(ans);
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
