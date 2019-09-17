package cfed64;
import java.io.*;
import java.util.*;

public class C{
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		long n=sc.nextLong(),k=sc.nextLong();
		TreeMap<Long,Integer>map=new TreeMap<Long,Integer>();
		for(int i=0;i<n;i++){
			long x=sc.nextLong();
			map.put(x,map.containsKey(x)?map.get(x)+1:1);
		}
		boolean possible=true;
		int ct=0;
		while(!map.isEmpty()&&possible){
			Long x=map.firstKey();
			Long y=map.ceilingKey(x+k);
			if(k==0&&map.get(x)==1)
				ct--;
			remove(map,x);
			remove(map,y);
			if(y==null)
				possible=false;
			else
				ct++;
		}
		System.out.println(ct);
		// ------------------------
		out.close();
	}
	//------------------------
	private static boolean remove(TreeMap<Long,Integer>map,Long x){
		if(x==null||!map.containsKey(x))
			return false;
		if(map.get(x)==1){
			map.remove(x);
			return true;
		}
		map.put(x,map.get(x)-1);
		return true;
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
