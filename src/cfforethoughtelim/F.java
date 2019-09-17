package cfforethoughtelim;
import java.io.*;
import java.util.*;

public class F{
	// ------------------------
	private static int n;
	private static HashMap<Integer,HashSet<Integer>>tree=new HashMap<Integer,HashSet<Integer>>();
	private static long[]fWays,xWays;
	private static long MOD=  998244353;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		n=sc.nextInt();
		fWays=new long[n];
		xWays=new long[n];
		for(int i=0;i<n;i++)
			tree.put(i,new HashSet<Integer>());
		for(int i=1;i<n;i++)
			tree.get(sc.nextInt()-1).add(i);
		System.out.println(getWays(0));
		// ------------------------
		out.close();
	}
	//------------------------
	private static long getWays(int i){
		if(tree.get(i).isEmpty()){
			fWays[i]=1;
			return 1;
		}
		long bs=1;
		xWays[i]=1;
		for(int j:tree.get(i)){
			getWays(j);
			xWays[i]=(xWays[i]*(xWays[j]+fWays[j]))%MOD;
			bs=(bs*(fWays[j]+1))%MOD;
		}
		fWays[i]=Math.max(0,bs-1-tree.get(i).size());
		return xWays[i]+fWays[i];
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