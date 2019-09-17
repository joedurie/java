package cf570d3;
import java.io.*;
import java.util.*;

public class E{
	// ------------------------
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),k=sc.nextInt();
		char[]s=sc.nextLine().toCharArray();
		ArrayList<Integer>lens=new ArrayList<Integer>();
		char last='*';
		int len=-1;
		for(int i=0;i<n;i++){
			if(s[i]!=last){
				if(last!='*')
					lens.add(len);
				len=0;
				last=s[i];
			}
			len++;
		}
		lens.add(len);
		long ans=0,i=0;
		while(ans<k){
			//int x=choose[n][i]-parts(0,i);
		}
		out.println(lens);
		// ------------------------
		out.close();
	}
	//------------------------
	//private static int 
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
