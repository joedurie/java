package cf553d2;

import java.io.*;
import java.util.*;

public class C {
	// ------------------------
	private static long MOD=1000000007;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		long l=sc.nextLong(),r=sc.nextLong();
		for(int i=0;i<10;i++)
		System.out.println(indexOdd(i));
		System.out.println((sumTo(r)-sumTo(l-1)+MOD)%MOD);
		// ------------------------
		out.close();
	}
	//------------------------
	private static long sumTo(long x){
		if(x==0)
			return 0;
		long o=maxOdd(x,0,Long.MAX_VALUE/2),e=maxEven(x,0,Long.MAX_VALUE/2);
		System.out.println(o+" " +e+" "+x);
		return (o+1)*(o+1)/4+(e/2)*(e/2+1);
	}
	private static long indexOdd(long l){
		long p=1,i=1;
		while(l>p){
			i+=3*p;
			l-=p;
			p*=4;
		}
		return i+l;
	}
	private static long indexEven(long l){
		l-=1;
		long p=2,i=2;
		while(l>p){
			i+=3*p;
			l-=p;
			p*=4;
		}
		return i+l;
	}
	private static long maxOdd(long x,long start,long end){
		if(end-start<2){
			if(indexOdd(end)<=x)
				return 2*end-1;
			return 2*start-1;
		}
		long mid=(start+end)/2;
		if(indexOdd(mid)<=x)
			return maxOdd(x,mid,end);
		return maxOdd(x,start,mid);
	}
	private static long maxEven(long x,long start,long end){
		if(end-start<2){
			if(indexEven(end)<=x)
				return 2*end;
			return 2*start;
		}
		long mid=(start+end)/2;
		if(indexEven(mid)<=x)
			return maxEven(x,mid,end);
		return maxEven(x,start,mid);
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