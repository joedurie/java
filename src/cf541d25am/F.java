package cf541d25am;
import java.io.*;
import java.util.*;

public class F{
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		int[]set=new int[n];
		int[]last=new int[n];
		int[]first=new int[n];
		int[]right=new int[n];
		for(int i=0;i<n;i++){
			set[i]=i;
			last[i]=i;
			first[i]=i;
			right[i]=-1;
		}
		boolean[]notFirst=new boolean[n];
		for(int i=0;i<n-1;i++){
			int x=sc.nextInt()-1,y=sc.nextInt()-1,t=x;
			while(x!=set[x])
				x=set[x];
			while(y!=set[y])
				y=set[y];
			set[x]=set[y];
			set[t]=set[y];
			right[last[x]]=first[y];
			notFirst[first[y]]=true;
			last[x]=last[y];
			first[y]=first[x];
		}
		int ind=-1;
		for(int i=0;i<n;i++)
			if(!notFirst[i]){
				ind=i;
				break;
			}
		while(ind!=-1){
			out.print((ind+1)+" ");
			ind=right[ind];
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