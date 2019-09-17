package cf584d12;
//package cf584d12;
import java.io.*;
import java.util.*;
import static java.lang.Math.*;
 
public class G {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int t = sc.nextInt();
		for(int w = 0; w < t; w++) {
			int n = sc.nextInt(), m = sc.nextInt();
			TreeSet<X> set = new TreeSet<X>();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					set.add(new X(i, j, sc.nextInt()));
			Y[] top4 = new Y[n];
			int min = set.last().a, sum = 0;
			for(int i = 0; i < n; i++) {
				top4[i] = new Y(set.pollLast());
				min = min(top4[i].a, min);
				sum += top4[i].a;
			}
			Arrays.sort(top4);
			int ans = sum;
			if(n == 4 && top4[0].j == top4[1].j && top4[2].j == top4[3].j && top4[0].j != top4[2].j) {
				if(two(top4[0], top4[1]) != two(top4[2], top4[3])) {
					int oneCol = two(top4[0], top4[1]) ? top4[2].j : top4[0].j;
					if(set.last().j == oneCol) {
						int a = set.last().a;
						for(int i = 0; i < 4; i++)
							if(top4[i].j != oneCol || two(new Y(set.last()), top4[i]))
								a += top4[i].a;
						set.pollLast();
						int b = set.last().a;
						while(last2(set) && set.last().j == oneCol) {
							set.pollLast();
							b = set.last().a;
						}
						if(set.last().j == oneCol) {
							for(int i = 0; i < 4; i++)
								if(top4[i].j != oneCol || two(new Y(set.last()), top4[i]))
									b += top4[i].a;
						} else
							b += sum - min;
						ans = max(a, b);
					} else
						ans = sum - min + set.last().a;
				}
			}
			out.println(ans);
		}
		out.close();
	}
	static boolean last2(TreeSet<X> set) {
		X x = set.pollLast();
		boolean b = x.a == set.last().a;
		set.add(x);
		return b;
	}
	static boolean two(Y y1, Y y2) {
		return (y1.i - y2.i + 4) % 4 == 2;
	}
	static class Y implements Comparable<Y> {
		int i, j, a;
		public Y(X x) {
			i = x.i;
			j = x.j;
			a = x.a; 
		}
		public int compareTo(Y x) {
			if(j == x.j)
				return i - x.i;
			return j - x.j;
		}
	}
	static class X implements Comparable<X> {
		int i, j, a;
		public X(int I, int J, int A) {
			i = I;
			j = J;
			a = A; 
		}
		public int compareTo(X x) {
			if(a == x.a && i == x.i)
				return j - x.j;
			else if(a == x.a)
				return i - x.i;
			return a - x.a;
		}
	}
	public static PrintWriter out  = new PrintWriter(new BufferedOutputStream(System.out));
	public static class MyScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String next() {
			while (st == null || !st.hasMoreElements())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
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