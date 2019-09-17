package abc134;
import java.io.*;
import java.util.*;

public class E {
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		TreeMap<Integer,Integer>maxes=new TreeMap<Integer,Integer>();
		for(int i=0;i<n;i++){
			int ai=sc.nextInt();
			Integer x=maxes.floorKey(ai-1);
			if(x!=null){
				maxes.put(x,maxes.get(x)-1);
				if(maxes.get(x)==0)
					maxes.remove(x);
			}
			maxes.put(ai,maxes.containsKey(ai)?maxes.get(ai)+1:1);
		}
		int ans=0;
		for(int i:maxes.keySet())
			ans+=maxes.get(i);
		out.println(ans);
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
