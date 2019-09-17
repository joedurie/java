package cf552d3;

import java.io.*;
import java.util.*;

public class F {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
		Integer[]costs=new Integer[n];
		for(int i=0;i<n;i++)
			costs[i]=sc.nextInt();
		Arrays.sort(costs);
		int iC=k-1;
		Offer[]offers=new Offer[m];
		for(int i=0;i<m;i++)
			offers[i]=new Offer(sc.nextInt(),sc.nextInt());
		Arrays.sort(offers);
		for(Offer o:offers)
			System.out.println(o);
		int iO=0;
		long cost=0;
		while(iO<m&&iC>=0)
			if(offers[iO].x>iC+1)
				iO++;
			else{
				for(int i=0;i<offers[iO].x-offers[iO].y;i++)
					cost+=costs[iC--];
				for(int i=0;i<offers[iO].y;i++)
					iC--;
				iO++;
			}
		while(iC>=0)
			cost+=costs[iC--];
		System.out.println(cost);
		// ------------------------
		out.close();
	}
	//------------------------
	private static class Offer implements Comparable<Offer>{
		int x;
		int y;
		public Offer(int X,int Y){
			x=X;
			y=Y;
		}
		public int compareTo(Offer o){
			if(x-y!=o.x-o.y)
				return ((Integer)(x-y)).compareTo(o.x-o.y);
			return -((Integer)x).compareTo(o.x);
		}
		public String toString(){
			return x+" "+y;
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
