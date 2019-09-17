package cf525d2;
import java.io.*;
import java.util.*;

public class E {
	// ------------------------
	static ArrayList<HashSet<Integer>>tree=new ArrayList<HashSet<Integer>>();
	static int[]a;
	static boolean[]vis;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		a=new int[n];
		vis=new boolean[n];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			max=Math.max(max,a[i]);
			tree.add(new HashSet<Integer>());
		}
		for(int i=0;i<n-1;i++){
			int u=sc.nextInt()-1,v=sc.nextInt()-1;
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		if(max<0){
			int ct=0;
			for(int i:a)
				if(i==max)
					ct++;
			System.out.println(ct*max+" "+ct);
		}else{
			ArrayList<Long>pos=new ArrayList<Long>();
			for(int i=0;i<n;i++)
				if(!vis[i]&&a[i]>=0)
					pos.add(dfs(i));
			Collections.sort(pos);
			int ct=0;
			while(ct<pos.size()&&pos.get(ct)==pos.get(0))
				ct++;
			System.out.println(ct*pos.get(0)+" "+ct);
		}
		// ------------------------
		out.close();
	}
	//------------------------
	static long dfs(int i){
		vis[i]=true;
		long ans=a[i];
		for(int j:tree.get(i))
			if(!vis[j]){
				long d=dfs(j);
				if(d>=0)
					ans+=d;
				else
					unfill(j,i);
			}
		return ans;
	}
	static void unfill(int i,int p){
		vis[i]=false;
		for(int j:tree.get(i))
			if(j!=p)
				unfill(j,i);
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
