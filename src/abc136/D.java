package abc136;
import java.io.*;
import java.util.*;

public class D {
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		char[] s = sc.nextLine().toCharArray();
		int[] ans = new int[s.length];
		int r = 0, lastRL = -1;
		for(int i = 0; i < s.length; i++) {
			if(i + 1 < s.length && s[i] == 'R' && s[i + 1] == 'L') {
				ans[i] = 1 + r / 2;
				ans[i + 1] = 1 + (r + 1) / 2;
				r = 0;
				lastRL = i;
				i++;
			} else if (s[i] == 'R')
				r++;
			else if (s[i] == 'L')
				ans[lastRL + (i - lastRL) % 2]++;
		}
		for(int i : ans)
			out.print(i + " ");
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
