package abc136;
import java.io.*;
import java.util.*;

public class E {
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n = sc.nextInt(), k = sc.nextInt();
		long sum = 0;
		long[] a = new long[n];
		for(int i = 0; i < n; i++)
			sum += a[i] = sc.nextInt();
		TreeSet<Long>set = new TreeSet<Long>();
		for(int i = 1; i * i <= sum; i++)
			if(sum % i == 0) {
				set.add((long)i);
				set.add(sum / i);	
			}
		while(!set.isEmpty())
			if(works(a, k, set.last())) {
				out.println(set.last());
				break;
			} else
				set.pollLast();
		// ------------------------
		out.close();
	}
	//------------------------
	public static boolean works(long[] a, int k, long x) {
		long[] b = new long[a.length];
		for(int i = 0; i < b.length; i++)
			b[i] = a[i] % x;
		Arrays.sort(b);
		int add = b.length - 1, sub = 0, i = 0;
		while(i < k){
			while(add >= 0 && b[add] == x)
				add--;
			while(sub < b.length && b[sub] == 0)
				sub++;
			if(add <= sub)
				break;
			long d = Math.min(k - i, Math.min(b[sub], x - b[add]));
			b[add] += d;
			b[sub] -= d;
			i += d;
		}
		for(long l : b)
			if(l % x != 0)
				return false;
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
