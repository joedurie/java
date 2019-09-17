package cf531d3;
import java.io.*;
import java.util.*;

public class C{
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
		TreeMap<Integer,Integer>map=new TreeMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			int g=sc.nextInt();
			map.put(g,map.containsKey(g)?map.get(g)+1:1);
		}
		if(x>y)
			out.println(n);
		else{
			int ct=0;
			while(map.firstKey()<x){
				int g=map.floorKey(x);
				map.put(g,map.get(g)-1);
				if(map.get(g)==0)
					map.remove(g);
				ct++;
				int h=map.ceilingKey(x+1-y);
				map.put(h,map.get(h)-1);
				if(map.get(h)==0)
					map.remove(h);
				map.put(h+y,map.containsKey(h+y)?map.get(h+y)+1:1);
			}
			out.println(ct);
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

