package cf545d2;
import java.io.*;
import java.util.*;

public class A {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),last=sc.nextInt();//,ind=-1;
		Stack<Integer>st=new Stack<Integer>();
		int i=1,len=0;
		while(i<n){
			int c=sc.nextInt();
			len=1;
			//System.out.println(c+" "+i);
			i++;
			while(c==last){
				last=c;
				c=i==n?-1:sc.nextInt();
				i++;
				len++;
			}
			last=c;
			st.push(len);
		}
		if(len==1)
			st.push(1);
		//System.out.println(st);
		int max=0,curr=0;
		while(!st.isEmpty()){
			int temp=st.pop();
			max=Math.max(max,2*Math.min(curr,temp));
			curr=temp;
		}
		System.out.println(max);
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