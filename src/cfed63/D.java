package cfed63;
import java.io.*;
import java.util.*;

class A{
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),x=sc.nextInt();
		long[]a=new long[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextLong();
		if(x>=0)
			System.out.println(Math.max(1,x)*beauty(a,n));
		else{
			long sum=0,max=0;
			int right=-1;
			for(int i=0;i<n;i++){
				if(sum+a[i]>0){
					if(sum<max)
						right=i-1;
					sum=0;
				}else
					sum+=a[i];
			}
			if(sum<max)
				right=n-1;
			sum=0;
			while(right>=0&&sum+a[right]<=0){
				sum+=a[right];
				a[right]*=x;
				right--;
			}
			//for(long i:a)
			//	System.out.println(i);
			System.out.println(beauty(a,n));
		}
		// ------------------------
		out.close();
	}
	//------------------------
	private static long beauty(long[]a,int n){
		long sum=0,max=0;
			for(int i=0;i<n;i++){
				if(sum+a[i]<0){
					max=Math.max(sum,max);
					sum=0;
				}else
					sum+=a[i];
			}
		return Math.max(sum,max);
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
