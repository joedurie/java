package cf552d3;

import java.io.*;
import java.util.*;

public class G {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		BS[]a=new BS[n];
		for(int i=1;i<=n;i++)
			a[i-1]=new BS(sc.nextLong(),i);
		Arrays.sort(a);
		int x=-1,y=-1,badInd=n;
		long lcm=Long.MAX_VALUE;
		for(int i=0;i<badInd;i++)
			for(int j=i+1;j<badInd;j++){
				long temp=a[i].v*a[j].v/gcd(a[i].v,a[j].v);
				if(temp<lcm){
					lcm=temp;
					x=a[i].i;
					y=a[j].i;
					badInd=ind(a,lcm,0,badInd-1);
				}
			}
		System.out.println((int)Math.min(x,y)+" "+(int)Math.max(x,y));
		// ------------------------
		out.close();
	}
	private static int ind(BS[]a,long cap,int start,int end){
		if(end-start<2)
			return a[start].v>=cap?start:(a[end].v>=cap?end:end+1);
		int mid=(start+end)/2;
		if(a[mid].v>=cap)
			return ind(a,cap,start,mid);
		return ind(a,cap,mid+1,end);
	}
	private static long gcd(long a,long b){
		return b==0?a:gcd(b,a%b);
	}
	//------------------------
	private static class BS implements Comparable<BS>{
		long v;
		int i;
		public BS(long V,int I){
			v=V;
			i=I;
		}
		public int compareTo(BS other){
			return ((Long)v).compareTo(other.v);
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
