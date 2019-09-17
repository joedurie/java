package cf556d1;
import java.io.*;
import java.util.*;

public class B{
	// ------------------------
	static char[]s;
	static char[][]lists=new char[3][250];
	static int[]size={0,0,0};
	static int[]arr={0,0,0};
	static int iS=0;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),q=sc.nextInt();
		s=sc.nextLine().toCharArray();
		boolean lastWorked=false;
		for(int w=0;w<q;w++){
			char[]line=sc.nextLine().toCharArray();
			char sign=line[0];
			int i=line[2]-'1';
			if(sign=='+'){
				size[i]++;
				lists[i][size[i]-1]=line[4];
				lastWorked=works(false);
				out.println(lastWorked?"YES":"NO");
			}else{
				size[i]--;
				arr=new int[]{0,0,0};
				iS=0;
				if(lastWorked)
					System.out.println("YES");
				else{
					lastWorked=works(true);
					out.println(lastWorked?"YES":"NO");
				}
			}
		}
		// ------------------------
		out.close();
	}
	//------------------------
	private static boolean works(boolean repeat){
		boolean empty=true;
		for(int i=0;i<3;i++)
			if(arr[i]!=size[i])
				empty=false;
		if(empty)
			return true;
		if(iS==s.length){
			if(repeat)
				return false;
			arr=new int[]{0,0,0};
			iS=0;
			return works(true);
		}
		for(int i=0;i<3;i++)
			if(arr[i]<size[i]&&lists[i][arr[i]]==s[iS]){
				iS++;
				arr[i]++;
				if(works(repeat))
					return true;
				arr[i]--;
				iS--;
			}
		iS++;
		if(works(repeat))
			return true;
		iS--;
		return false;
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