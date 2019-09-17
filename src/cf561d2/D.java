package cf561d2;
import java.io.*;
import java.util.*;

public class D {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int q=sc.nextInt();
		for(int w=0;w<q;w++){
			long a=sc.nextLong(),b=sc.nextLong(),m=sc.nextLong();
			LinkedList<Long>ll=new LinkedList<Long>();
			ll.add(a);
			ll.add(a+1);
			long cumSum=2*a+1;
			while(ll.size()<50&&cumSum+1<=b){
				ll.add(cumSum+1);
				cumSum+=cumSum+1;
			}
			long x=b-ll.getLast();
			long[]diff=new long[ll.size()-1];
			for(int i=0;i<diff.length;i++){
				long p=(long)Math.pow(2,Math.max(0,diff.length-i-2));
				diff[i]=Math.min(x/p,m-1);
				x-=p*diff[i];
			}
			if(x!=0)
				out.println(-1);
			else{
				out.print(ll.size()+" ");
				out.print(a+" ");
				ll.removeFirst();
				long prop=0;
				for(int i=0;i<diff.length;i++){
					out.print((prop+diff[i]+ll.removeFirst())+" ");
					prop=2*prop+diff[i];
				}
				out.println();
			}
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
