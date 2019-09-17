package cfed64;
import java.io.*;
import java.util.*;

public class B{
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int t=sc.nextInt();
		for(int w=0;w<t;w++){
			char[]s=sc.nextLine().toCharArray();
			int[]ct=new int[26];
			for(char c:s)
				ct[c-'a']++;
			ArrayList<Integer>list=new ArrayList<Integer>();
			boolean possible=true;
			for(int i=0;i<26;i++){
				if(ct[i]>0){
					int ind=0;
					while(ind<list.size()&&(Math.abs(list.get(ind)-i)==1||(ind>0&&Math.abs(list.get(ind-1)-1)==1)))
						ind++;
					if(ind==list.size()){
						if(!list.isEmpty()&&Math.abs(list.get(ind-1)-i)==1){
							
						}else
							list.add(i);
					}else
						list.add(ind,i);
				}
			}
			if(!possible)
				System.out.println("No answer");
			else{
				for(int i:list)
					System.out.print(rep((char)(i+'a'),ct[i]));
				System.out.println();
			}
		}
		// ------------------------
		out.close();
	}
	//------------------------
	private static String rep(char c,int i){
		String s="";
		for(int x=0;x<i;x++)
			s+=c+"";
		return s;
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
