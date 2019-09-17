package cf572d1;
import java.io.*;
import java.util.*;

public class F{
	// ------------------------
	static class Edge implements Comparable<Edge>{
		int v, w;
		public Edge(int V,int W){
			v=V;
			w=W;
		}
		public int compareTo(Edge e){
			return w-e.w;
		}
	}
	static HashMap<Integer,TreeSet<Edge>>tree=new HashMap<Integer,TreeSet<Edge>>();
	static HashMap<Integer,TreeSet<Edge>>lvs=new HashMap<Integer,TreeSet<Edge>>();
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		for(int i=0;i<n;i++){
			tree.put(i,new TreeSet<Edge>());
			lvs.put(i, new TreeSet<Edge>());
		}
		for(int i=0;i<n-1;i++){
			int a=sc.nextInt(),b=sc.nextInt(),w=sc.nextInt();
			tree.get(a).add(new Edge(b,w));
			tree.get(b).add(new Edge(a,w));
		}
		boolean ok=true;
		for(int i=0;i<n;i++)
			if(tree.get(i).size()==2)
				ok=false;
		out.println(ok?"YES":"NO");
		if(ok){
			int root=tree.get(0).size()==1?tree.get(0).first().v:0;
			getAns(root,-1, 0);
		}
		// ------------------------
		out.close();
	}
	//------------------------
	private static void getAns(int i,int p,int w){
		lvs.put(i,new TreeSet<Edge>());
		if(lvs.size()==1)
			lvs.get(i).add(new Edge(i,w));
		else{
			for(Edge e:tree.get(i))
				if(e.v!=p)
					getAns(e.v,i,e.w);
			int sum=0;
			for(Edge e:tree.get(i))
				if(e.v==p){
					sum-=e.w;
					tree.remove(e);
				}else
					sum+=e.w;
			Edge e1=tree.get(i).pollLast(),e2=tree.get(i).pollLast();
			print(e1,e2,-sum/2);
			tree.get(i).add(e1);
			tree.get(i).add(e2);
			for(Edge e:tree.get(i))
				if(e.v!=p&&e.w!=0){
					if(lvs.get(e.v).isEmpty())
						lvs.get(i).add(e);
					else if(lvs.get(e.v).size()<=lvs.get(i).size())
						lvs.get(i).addAll(lvs.remove(e.v));
					else{
						lvs.get(e.v).addAll(lvs.get(i));
						lvs.put(i,lvs.remove(e.v));
					}
				}
		}
	}
	private static void print(Edge e1, Edge e2, int del){
		if(lvs.get(e1.v).isEmpty()){
			lvs.put(e1.v,new TreeSet<Edge>());
			lvs.get(e1.v).add(e1);
		}
		if(lvs.get(e2.v).isEmpty()){
			lvs.put(e2.v,new TreeSet<Edge>());
			lvs.get(e2.v).add(e2);
		}
		Edge l1 = lvs.get(e1.v).pollLast(), l2 = lvs.get(e2.v).pollLast();
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
