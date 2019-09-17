package cfglobal2;
import java.io.*;
import java.util.*;

public class E {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt();
		long[]a=new long[n];
		long[]pSum=new long[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			pSum[i]=a[i]+(i==0?0:a[i-1]);
		}
		long pending=0,done=0;
		for(int i=n-1;i>=0;i--){
			if(a[i]%2==1&&pending>0){
				a[i]--;
				pending--;
				done++;
			}
			long x=bsearch(0,a[i],a[i],pending,(i==0?0:pSum[i-1]));
			a[i]-=x;
			pending-=x;
			done+=x;
			pending+=a[i]/2;
			System.out.println(i+" "+pending+" "+done);
		}
		System.out.println(done);
		// ------------------------
		out.close();
	}
	//------------------------
	private static long bsearch(long min,long max,long ai,long pending,long after){
		if(max-min<2){
			if(works(min,ai,pending,after))
				return min;
			if(works(max,ai,pending,after))
			return max;
			System.out.println("FUCKERK+YFUCKJAGK");
			return 1;
		}
		long mid=(min+max)/2;
		if(works(mid,ai,pending,after))
			return bsearch(min,mid,ai,pending,after);
		return bsearch(mid+1,max,ai,pending,after);
	}
	private static boolean works(long x,long ai,long pending,long after){
		return x<=pending+(ai-x)/2;//&&after+x>=(ai-x)/2+pending;
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
