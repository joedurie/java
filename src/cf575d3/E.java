package cf575d3;
import java.io.*;
import java.util.*;

public class E {
	// ------------------------
	static class C implements Comparable<C>{
		int x,y,p;
		public C(int X,int Y){
			x=X;
			y=Y;
			p=0;
		}
		public C(int X,int Y,HashSet<String>used){
			x=X;
			y=Y;
			p=0;
			HashSet<C>n=nbrs();
			for(C x:n)
				if(used.contains(x.st()))
					p++;
		}
		public void inc(){
			p++;
		}
		public String st(){
			return x+" "+y;
		}
		public int compareTo(C other){
			if(p==other.p)
				return st().compareTo(other.st());
			return p-other.p;
		}
		public HashSet<C>nbrs(){
			HashSet<C>nbrs=new HashSet<C>();
			int[]dx={0,0,1,-1};
			int[]dy={1,-1,0,0};
			for(int i=0;i<4;i++)
				nbrs.add(new C(x+dx[i],y+dy[i]));
			return nbrs;
		}
	}
	static void addNeighbors(PriorityQueue<C>ll,C c,HashSet<String>used){
		HashSet<C>set=c.nbrs();
		for(C x:set)
			if(!used.contains(x.st()))
				ll.add(x);
	}
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int t=sc.nextInt();
		for(int q=0;q<t;q++){
			int b=sc.nextInt(),w=sc.nextInt()-1;
			PriorityQueue<C>white=new PriorityQueue<C>();
			PriorityQueue<C>black=new PriorityQueue<C>();
			HashSet<String>used=new HashSet<String>();
			C start=new C(1000000, 1000000);
			addNeighbors(black,start,used);
			used.add(start.st());
			boolean possible=true;
			while(possible&&(w>0||b>0)){
				if(w>=b&&!white.isEmpty()){
					C x=white.poll();
					if(!used.contains(x.st())){
						used.add(x.st());
						addNeighbors(black,x,used);
						w--;
					}
				}else if(b>0&&!black.isEmpty()){
					C x=black.poll();
					if(!used.contains(x.st())){
						used.add(x.st());
						addNeighbors(white,x,used);
						b--;
					}
				}else
					possible=false;
			}
			out.println(possible?"YES":"NO");
			if(possible)
				for(String s:used)
					out.println(s);
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
