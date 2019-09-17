package cf576d1;
import java.io.*;
import java.util.*;

public class A {
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		long n=sc.nextLong(),I=sc.nextLong();
		if(I*8/n>=32)
			out.println(0);
		else{
			long k=1<<(I*8/n);
			Long[]a=new Long[(int)n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextLong();
			Arrays.sort(a);
			Integer[]distinct=new Integer[(int)n];
			distinct[0]=1;
			for(int i=1;i<n;i++)
				distinct[i]=distinct[i-1]+(a[i]==a[i-1]?0:1);
			long min=n;
			for(int i=0;i<n;i++)
				min=Math.min(min,i+n-bs(distinct[i],k,i+1,(int)n,distinct));
			out.println(min);
		}
		// ------------------------
		out.close();
	}
	//------------------------
	public static long bs(long x,long k,int l,int r,Integer[]a){
		if(l==r)
			return l;
		int m=(l+r)/2;
		if(a[m]-x<k)
			return bs(x,k,m+1,r,a);
		return bs(x,k,l,m,a);
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
