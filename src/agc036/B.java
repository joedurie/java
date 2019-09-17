package agc036;
import java.io.*;
import java.util.*;

public class B {
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		long k=sc.nextLong();
		int[]x=new int[n];
		HashMap<Integer,TreeSet<Integer>>map=new HashMap<Integer,TreeSet<Integer>>();
		for(int i=1;i<=200000;i++)
			map.put(i,new TreeSet<Integer>());
		for(int i=0;i<n;i++){
			x[i]=sc.nextInt();
			map.get(x[i]).add(i);
		}
		int[]next=new int[n];
		for(int i=1;i<=200000;i++)
			if(!map.get(i).isEmpty()){
				int f=map.get(i).pollFirst(),cur=f;
				while(!map.get(i).isEmpty()){
					next[cur]=map.get(i).first();
					cur=map.get(i).pollFirst();
				}
				next[cur]=f;
			}
		int[]roundUsed=new int[n];
		long ind=0;
		while(ind<n*k&&roundUsed[(int)(ind%n)]==0){
			roundUsed[(int)(ind%k)]=(int)(ind/n)+1;
			long lastM=ind%n;
			ind=(ind/n)+next[(int)(ind%n)];
			if(ind%n<=lastM)
				ind+=n;
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
