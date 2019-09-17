package cf569d1;
import java.io.*;
import java.util.*;

public class D {
	// ------------------------
	private static HashMap<Integer,HashSet<Integer>>graph=new HashMap<Integer,HashSet<Integer>>();
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
			graph.put(i,new HashSet<Integer>());
		for(int i=0;i<n-1;i++){
			int a=sc.nextInt()-1,b=sc.nextInt()-1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		int v1=longPath(0,-1)[1];
		long max=n-1;
		/*HashSet<Integer>verts=longPath
		for(int )
		System.out.println(longPath2(v1,-1));*/
		// ------------------------
		out.close();
	}
	//------------------------
	static class X{
		int len;
		HashSet<Integer>verts;
		public X(int l,HashSet<Integer>h){
			len=l;
			verts=h;
		}
	}
	private static X longPath2(int i,int p){
		HashSet<Integer>h=new HashSet<Integer>();
		h.add(i);
		X ans=new X(0,h);
		for(int j:graph.get(i))
			if(j!=p){
				X x=longPath2(j,i);
				if(x.len+1>ans.len)
					ans=x;
				else if(x.len+1==ans.len)
					ans.verts.addAll(x.verts);
			}
		return ans;
	}
	private static int[]longPath(int i,int p){
		int len=0,ind=i;
		for(int j:graph.get(i))
			if(j!=p){
				int[]a=longPath(j,i);
				if(a[0]+1>len){
					len=a[0]+1;
					ind=a[1];
				}
			}
		return new int[]{len,ind};
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
