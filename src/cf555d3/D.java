package cf555d3;
import java.io.*;
import java.util.*;

public class D{
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		long n=sc.nextLong(),k=sc.nextLong();
		ArrayList<Long>ans=new ArrayList<Long>();
		boolean ok=true;
		while(k>0&&ok){
			long x=(long)Math.ceil((n+s(k)+k)/(double)k);
			System.out.println(n+"-"+s(k)+"/"+k+" = "+x);
			long y=ans.isEmpty()?0:ans.get(0);
			if(x<1||(y>0&&(2*x<y||x>=y)))
				ok=false;
			else{
				ans.add(x);
				n-=x;
				k--;
			}
		}
		if(!ok)
			out.println("NO");
		else{
			out.println("YES");
			for(int i=ans.size()-1;i>=0;i--)
				out.print(ans.get(i)+" ");
			out.println();
		}
		// ------------------------
		out.close();
	}
	private static long s(long x){
		return x*(x-1)/2;
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
