package cf559d1;
import java.io.*;
import java.util.*;

public class A{
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),m=sc.nextInt();
		TreeMap<Integer,Integer>map=new TreeMap<Integer,Integer>();
		TreeMap<Integer,Integer>ct=new TreeMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			add(map,x,m);
			add(ct,x,1);
		}
		Integer[]a=new Integer[m];
		boolean ok=true;
		for(int i=0;i<m;i++){
			a[i]=sc.nextInt();
			if(a[i]<map.lastKey())
				ok=false;
		}
		long ans=0;
		Arrays.sort(a);
		for(int i:a){
			ans+=i;
			if(i==map.lastKey())
				ct.put(map.lastKey(),ct.get(map.lastKey())+1);
			//out.println(map);
			//out.println(ans);
			ans+=pollLast(map,ct);
			//out.println(ans);
		}
		while(!map.isEmpty()){
			ans+=(long)map.get(map.lastKey())*(long)map.lastKey();
			map.pollLastEntry();
			//out.println(ans);
		}
		out.println(ok?ans:-1);
		// ------------------------
		out.close();
	}
	//------------------------
	public static void add(TreeMap<Integer,Integer>map,int x,int k){
		map.put(x,map.containsKey(x)?map.get(x)+k:k);
	}
	public static long pollLast(TreeMap<Integer,Integer>map,TreeMap<Integer,Integer>ct){
		int x=map.lastKey();
		if(map.get(x)==ct.get(x)){
			int y=ct.get(x);
			map.remove(x);
			ct.remove(x);
			return (long)x*(long)y+pollLast(map,ct);
		}
		map.put(x,map.get(x)-1);
		if(map.get(x)==0)
			map.remove(x);
		return 0;
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
