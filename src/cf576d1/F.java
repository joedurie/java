package cf576d1;
import java.io.*;
import java.util.*;

public class F {
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		long n=sc.nextLong(),I=sc.nextLong();
		if(I*8/n>=32)
			out.println(0);
		else{
			long k=1<<(I*8/n);
			HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
			for(int i=0;i<n;i++){
				int key=sc.nextInt();
				map.put(key,map.containsKey(key)?map.get(key)+1:1);
			}
			Integer[]arr=new Integer[map.keySet().size()];
			int ind=0;
			for(int i:map.keySet())
				arr[ind++]=map.get(i);
			Arrays.sort(arr);
			long ans=0;
			for(int i=0;i<arr.length-k;i++)
				ans+=arr[i];
			out.println(ans);
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
