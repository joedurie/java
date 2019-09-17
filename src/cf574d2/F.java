package cf574d2;
import java.io.*;
import java.util.*;

public class F{
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),m=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt();
		long g=sc.nextLong(),x=sc.nextLong(),y=sc.nextLong(),z=sc.nextLong();
		int[][]grid=new int[n][m];
		for(int i=0;i<n*m;i++){
			grid[i/m][i%m]=(int)g;
			g=(g*x+y)%z;
		}
		int[][]rMins=new int[n][m-b+1];
		for(int i=0;i<n;i++){
			TreeMap<Integer,Integer>pq=new TreeMap<Integer,Integer>();
			for(int j=0;j<b;j++)
				add(pq,grid[i][j]);
			for(int j=b;j<m;j++){
				rMins[i][j-b]=pq.firstKey();
				add(pq,grid[i][j]);
				remove(pq,grid[i][j-b]);
			}
			rMins[i][m-b]=pq.firstKey();
		}
		long sum=0;
		for(int j=0;j<m-b+1;j++){
			TreeMap<Integer,Integer>pq=new TreeMap<Integer,Integer>();
			for(int i=0;i<a;i++)
				add(pq,rMins[i][j]);
			for(int i=a;i<n;i++){
				sum+=pq.firstKey();
				add(pq,rMins[i][j]);
				remove(pq,rMins[i-a][j]);
			}
			sum+=pq.firstKey();
		}
		out.println(sum);
		// ------------------------
		out.close();
	}
	//------------------------
	static void add(TreeMap<Integer,Integer>m,int x){
		m.put(x,m.containsKey(x)?m.get(x)+1:1);
	}
	static void remove(TreeMap<Integer,Integer>m,int x){
		m.put(x,m.get(x)-1);
		if(m.get(x)==0)
			m.remove(x);
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
