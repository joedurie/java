package cf562d1;
import java.io.*;
import java.util.*;

public class C {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),q=sc.nextInt();
		int[]a=new int[n];
		int[][]grid=new int[n+1][19];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			for(int j=0;j<19;j++){
				int x=(a[i]&(1<<j))>0?1:0;
				grid[i+1][j]=x+grid[i][j];
			}
		}
		for(int i=0;i<q;i++){
			int l=sc.nextInt(),r=sc.nextInt();
			boolean b=false;
			for(int j=0;j<19;j++)
				if(grid[r-1][j]-grid[l-1][j]>0&&(a[r-1]&(1<<j))>0)
					b=true;
			out.println(b?"Shi":"Fou");
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
