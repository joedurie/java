package cfed67;
import java.io.*;
import java.util.*;

public class D{
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int t=sc.nextInt();
		for(int w=0;w<t;w++){
			int n=sc.nextInt();
			LinkedList<Integer>a=new LinkedList<Integer>();
			for(int i=0;i<n;i++)
				a.addLast(sc.nextInt());
			int[]b=new int[n];
			for(int i=0;i<n;i++)
				b[i]=sc.nextInt();
			PriorityQueue<Integer>sorted=new PriorityQueue<Integer>();
			int ind=0;
			while(!a.isEmpty()||!sorted.isEmpty()){
				if(!sorted.isEmpty()){
					if(b[ind]==sorted.peek()){
						sorted.poll();
						ind++;
					}else if(!a.isEmpty())
						sorted.add(a.pollFirst());
					else
						sorted=new PriorityQueue<Integer>();
				}else if(a.peekFirst()==b[ind]){
					a.pollFirst();
					ind++;
				}else
					sorted.add(a.pollFirst());
			}
			out.println(ind==n?"YES":"NO");
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
