package cf550d3;
import java.io.*;
import java.util.*;

public class G {
	// ------------------------
	private static int[]a;
	private static ArrayList<Integer>lis=new ArrayList<Integer>();
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int[]last=new int[n];
		for(int i=0;i<n;i++)
			last[i]=-1;
		lis.add(0);
		for(int i=1;i<n;i++){
			int j=bullshit(i,0,lis.size());
			if(j==lis.size()){
				last[i]=lis.get(lis.size()-1);
				lis.add(i);
			}else if(a[i]<a[lis.get(j)]){
				if(j>0)
					last[i]=lis.get(j-1);
				lis.set(j,i);
			}
		}
		HashSet<Integer>seq=new HashSet<Integer>();
		int x=lis.get(lis.size()-1);
		while(x!=-1){
			seq.add(x);
			x=last[x];
		}
		boolean good=true;
		int big=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
			if(!seq.contains(i)){
				if(a[i]<big)
					big=a[i];
				else
					good=false;
			}
		System.out.println(good?"YES":"NO");
		if(good)
			for(int i=0;i<n;i++)
				out.print(seq.contains(i)?"0 ":"1 ");
		// ------------------------
		out.close();
	}
	private static int bullshit(int i,int st,int en){
		if(en-st<2){
			if(a[lis.get(st)]>=a[i])
				return st;
			return en;
		}
		int mid=(st+en)/2;
		if(a[lis.get(mid)]>=a[i])
			return bullshit(i,st,mid);
		return bullshit(i,mid,en);
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
