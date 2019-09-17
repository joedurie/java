package swerc13;
import java.io.*;
import java.util.*;

public class H {
	static long[][][][] dp;
	static char[] t;
	static long MOD = 21092013;
	static Stack<Boolean> lC = new Stack<Boolean>();
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int q = sc.nextInt();
		for(int w = 1; w <= q; w++) {
			char[] s = sc.nextLine().toCharArray();
			t = sc.nextLine().toCharArray();
			lC = new Stack<Boolean>();
			for(char c : s) 
				if(c == 'U') {
					if(!lC.isEmpty()) 
						lC.pop();
				} else
					lC.push(c == 'L');
			dp = new long[t.length][2][2][2];
			out.println("Case " + w + ": " + dp(0, 1, 1, 1, lC.size()));
		}
		out.close();
	}
	static long dp(int i, int l, int r, int u, int h) {
		if(i == t.length)
			return 1;
		if(h == 0) u = 0;
		if(dp[i][l][r][u] > 0)
			return dp[i][l][r][u];
		long ans = 0;
		if(l == 1 && t[i] == 'L')
			ans = (ans + dp(i + 1, 1, 1, 0, h + 1)) % MOD; 
		if(r == 1 && t[i] == 'R')
			ans = (ans + dp(i + 1, 1, 1, 0, h + 1)) % MOD;
		if(u == 1 && t[i] == 'U') {
			boolean b = lC.pop();
			ans = (ans + dp(i + 1, b ? 0 : 1, b ? 1 : 0, 1, h - 1)) % MOD;
		}
		ans = (ans + dp(i + 1, t[i] == 'L' ? 0 : l, t[i] == 'R' ? 0 : r, t[i] == 'U' ? 0 : u, h)) % MOD;
		return dp[i][l][r][u] = ans;
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
