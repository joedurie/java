package cfglobal4;
import java.io.*;
import java.util.*;

public class F2{
	// ------------------------
	static long MOD=998244353;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		sc.nextInt();
		int[]p=new int[n];
		for(int i=0;i<n;i++)
			p[i]=sc.nextInt();
		long[][]ways=new long[n][n];
		for(int i=0;i<n;i++)
			ways[0][i]=1;
		for(int l=1;l<n;l++){
			for(int i=l;i<n;i++){
				if(p[i]>p[i-1])
					ways[l][i]=2*ways[l-1][i]%MOD;
				else{
					int k=i-1;
					while(k>=i-l&&(k==i-l||p[k]>p[i])){
						int lK=k-(i-l);
						long a1=ways[lK][k];
						long a2=ways[i][l-lK];
						ways[l][i]+=a1*a2%MOD;
						System.out.println(l+" "+i+" "+k+" "+a1+" "+a2);
					}
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++)
				out.print(ways[i][j]+" ");
			out.println();
		}
		out.println(ways[n-1][n-1]);
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
