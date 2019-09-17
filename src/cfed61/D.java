package cfed61;
import java.io.*;
import java.util.*;

public class D {
	// ------------------------
	private static long[]a,b;
	private static int n;
	private static long k;
	private static TreeMap<Long,TreeSet<X>>queue=new TreeMap<Long,TreeSet<X>>();
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		n=sc.nextInt();
		k=sc.nextLong();
		a=new long[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextLong();
		b=new long[n];
		for(int i=0;i<n;i++)
			b[i]=sc.nextLong();
		for(int i=0;i<n;i++)
			if(k*b[i]>a[i]){
				long rnd=a[i]/b[i];
				if(!queue.containsKey(rnd))
					queue.put(rnd,new TreeSet<X>());
				queue.get(rnd).add(new X(a[i],b[i]));
			}
		//System.out.println(queue);
		//System.out.println(works(0));
		//System.out.println("\n\n\n");
		long l=0,r=2*(long)Math.pow(10,12);
		while(r-l>1){
			//System.out.println((l+r)/2);
			long mid=(l+r)/2;
			if(works(mid))
				r=mid;
			else
				l=mid+1;
		}
		//System.out.println(works(l));
		System.out.println(works(l)?l:(works(r)?r:-1));
		// ------------------------
		out.close();
	}
	//------------------------
	private static boolean works(long x){
		int time=0;
		TreeMap<Long,TreeSet<X>>temp=new TreeMap<Long,TreeSet<X>>();
		for(long l:queue.keySet()){
			temp.put(l,new TreeSet<X>());
			for(X e:queue.get(l))
				temp.get(l).add(new X(e.a,e.b));
		}
		while(time<k&&!temp.isEmpty()){
			TreeSet<X>set=temp.firstEntry().getValue();
			X e=set.pollFirst();
			//System.out.println(e);
			if(set.size()==0)
				temp.pollFirstEntry();
			//System.out.println(e.a-time*e.b);
			if(e.a-time*e.b<0)
				return false;
			time++;
			//System.out.println(time+" "+k*e.b+" "+(e.a+x));
			if(k*e.b>e.a+x){
				long rnd=(e.a+x)/e.b;
				if(!temp.containsKey(rnd))
					temp.put(rnd, new TreeSet<X>());
				temp.get(rnd).add(new X(e.a+x,e.b));
			}
			//System.out.println(temp);
		}
		return true;
	}
	static class X implements Comparable<X>{
		long a;
		long b;
		public X(long a,long b){
			this.a=a;
			this.b=b;
		}
		public int compareTo(X o){
			return o.a-this.a>0?1:-1;
		}
		public String toString(){
			return a+" "+b;
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