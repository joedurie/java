package cf524d2;
import java.io.*;
import java.util.*;

public class C {
	// ------------------------
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int t = sc.nextInt();
		for(int w  = 0; w < t; w++) {
			long n = sc.nextInt(), m = sc.nextInt();
			long x1 = sc.nextInt(), x2 = sc.nextInt(), y1 = sc.nextInt(), y2 = sc.nextInt();
			long x3 = sc.nextInt(), x4 = sc.nextInt(), y3 = sc.nextInt(), y4 = sc.nextInt();
			long white = (n*m + 1)/2, black = (n*m)/2;
			long overlap = 0;
			boolean wh = false;
			if(x3 <= x2 && x3 >= x1){
				if(y3 <= x2 && y3 >= x1){
					overlap = Math.min(x4 - x3 + 1,x2 - x3 + 1)*Math.min(y4 - y3 + 1,y2 - y3 + 1);
					wh = (x3 + y3) % 2 == 0;
				}else if(y4 <= x2 && y4 >= x1){
					overlap = Math.min(x4 - x3 + 1,x2 - x3 + 1)*Math.min(y4 - y3 + 1,y4 - y1 + 1);
					wh = (x3 + y1) % 2 == 0;
				}
			}else if(x4 <= x2 && x4 >= x1){
				if(y3 <= x2 && y3 >= x1){
					overlap = Math.min(x4 - x3 + 1,x4 - x1 + 1)*Math.min(y4 - y3 + 1,y2 - y3 + 1);
					wh = (x1 + y3 ) % 2 == 0;
				}else if(y4 <= x2 && y4 >= x1){
					overlap = Math.min(x4 - x3 + 1,x4 - x1 + 1)*Math.min(y4 - y3 + 1,y4 - y1 + 1);
					wh = (x1 + y1 ) % 2 == 0;
				}
			}
			//long whiteOverlap = overlap/2;
			//if(overlap%2==1&&wh)
				//whiteOverlap++;
			white+=(x2 - x1 + 1)*(y2 - y1 + 1)/2-overlap;
			if((x1 + y1) % 2 == 0)
				white--;
			black+=(x4 - x3 + 1)*(y4 - y3 + 1)/2;
			if((x3 + y3) % 2 == 1)
				black--;
			out.println(white+" "+black);
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
