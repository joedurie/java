package cfglobal4;
import java.io.*;
import java.util.*;

public class F{
	// ------------------------
	static long MOD=998244353;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		int[]p=new int[n];
		int[]rev=new int[n];
		int[]dsu=new int[n];
		int[]len=new int[n];
		for(int i=0;i<n;i++){
			p[i]=sc.nextInt()-1;
			rev[p[i]]=i;
			dsu[i]=i;
		}
		long ways=1;
		for(int w=0;w<=n-1;w++){
			int i=rev[w];
			boolean r=i!=n-1&&len[i+1]>0;
			boolean l=i!=0&&len[i-1]>0;
			if(l&&r){
				ways=ways*(1+len[dsu[i-1]])%MOD*(1+len[dsu[i+1]])%MOD;
				len[dsu[i+1]]+=1+len[dsu[i-1]];
				dsu[i]=dsu[i+1];
				dsu[dsu[i-1]]=dsu[i+1];
			}else if(l){
				ways=ways*(1*len[dsu[i-1]])%MOD;
				len[dsu[i-1]]++;
				dsu[i]=dsu[i-1];
			}else if(r){
				ways=ways*(1*len[dsu[i+1]])%MOD;
				len[dsu[i+1]]++;
				dsu[i]=dsu[i+1];
			}else
				len[i]=1;
			out.println(ways);
		}
		out.println(ways);
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
