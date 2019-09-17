package cf564d1;
import java.io.*;
import java.util.*;

public class A{
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		int[]a=new int[n+1];
		HashSet<Integer>hand=new HashSet<Integer>();
		LinkedList<Integer>deck=new LinkedList<Integer>();
		for(int i=0;i<n;i++)
			hand.add(sc.nextInt());
		int last=0;
		boolean inc=true;
		for(int i=0;i<n;i++){
			deck.add(sc.nextInt());
			if(deck.peekLast()!=i+1)
				inc=false;
			a[deck.peekLast()]=i-(deck.peekLast()-2);
			if(deck.peekLast()==last+1)
				last++;
			else
				last=0;
		}
		if(inc)
			out.println(0);
		else{
			int max=0;
			for(int i=last+1;i<=n;i++)
				max=Math.max(max,a[i]);
			if(max>0||!hand.contains(last+1)){
				for(int i=1;i<=last;i++)
					max=Math.max(max,a[i]);
				last=0;
			}
			out.println(max+n-last);
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