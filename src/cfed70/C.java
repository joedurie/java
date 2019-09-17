package cfed70;
import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = sc.nextInt();
		for(int w = 0; w < t; w++) {
			char[] s = sc.nextLine().toCharArray();
			LinkedList<Character> vert = new LinkedList<Character>();
			LinkedList<Character> hor = new LinkedList<Character>();
			for(char c : s)
				if(c == 'W' || c == 'S')
					vert.add(c);
				else
					hor.add(c);
			ArrayList<Integer> lenV = lens(vert);
			ArrayList<Integer> lenH = lens(hor);
			long curV = 0, curH = 0, maxV = 0, maxH = 0, minV = 0, minH = 0;
			for(char c : s) {
				if(c == 'W')
					curV++;
				else if(c == 'S')
					curV--;
				else if(c == 'A')
					curH--;
				else
					curH++;
				maxV = Math.max(curV, maxV);
				minV = Math.min(curV, minV);
				maxH = Math.max(curH, maxH);
				minH = Math.min(curH, minH);
			}
			long dV = maxV - minV + 1, dH = maxH - minH + 1;
			//out.println(dV + " "+ dH);
			long ans = dV * dH;
			int sV = lenV.size(), sH = lenH.size();
			long ddV = sV == 0 || (sV >= 2 && lenV.get(sV - 1) == lenV.get(sV - 2)) ? 0 : 1;
			long ddH = sH == 0 || (sH >= 2 && lenH.get(sH - 1) == lenH.get(sH - 2)) ? 0 : 1;
			out.println(dV +" "+ ddV + " "+dH+" "+ddH);
			ans = Math.min((dV - ddV) * dH, ans);
			ans = Math.min((dH - ddH) * dV, ans);
			out.println(ans);
		}
		out.close();
	}
	private static ArrayList<Integer> lens(LinkedList<Character> ll) {
		char last = 'X';
		int curr = 0;
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(char c : ll) {
			if(c != last) {
				if(curr != 0)
					l.add(curr);
				curr = 1;
			} else
				curr++;
			last = c;
		}
		Collections.sort(l);
		return l;
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
