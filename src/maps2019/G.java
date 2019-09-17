package maps2019;
import java.io.*;
import java.util.*;

public class G{
	// ------------------------
	static HashMap<String,Boolean>used=new HashMap<String,Boolean>();
	static HashMap<String,HashSet<String>>graph=new HashMap<String,HashSet<String>>();
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),m=sc.nextInt();
		HashMap<String,Integer>degrees=new HashMap<String,Integer>();
		for(int i=0;i<n;i++){
			String[]line=sc.nextLine().split(" ");
			if(!graph.containsKey(line[0]))
				graph.put(line[0],new HashSet<String>());
			used.put(line[0],false);
			if(!degrees.containsKey(line[0]))
				degrees.put(line[0],0);
			int x=Integer.parseInt(line[1]);
			for(int j=0;j<x;j++){
				if(!graph.containsKey(line[2+j]))
					graph.put(line[2+j],new HashSet<String>());
				if(!degrees.containsKey(line[2+j]))
					degrees.put(line[2+j],0);
				if(!line[0].equals(line[2+j])){
					graph.get(line[0]).add(line[2+j]);
					graph.get(line[2+j]).add(line[0]);
					degrees.put(line[0],degrees.get(line[0])+1);
					degrees.put(line[2+j],degrees.get(line[2+j])-1);
				}
			}
		}
		String root="";
		HashSet<String>temp=new HashSet<String>();
		for(String s:graph.keySet())
			if(graph.get(s).isEmpty())
				temp.add(s);
			else
				root=s;
		for(String s:temp)
			graph.remove(s);
		if(graph.isEmpty())
			out.println("FALSE ALARM");
		else if(dfs(root)!=graph.size())
			out.println("IMPOSSIBLE");
		else{
			boolean one=false,nOne=false,poss=true;
			for(String s:degrees.keySet()){
				int d=degrees.get(s);
				if(d!=0){
					if(d==1&&!one)
						one=true;
					else if(d==-1&&!nOne)
						nOne=true;
					else
						poss=false;
				}
			}
			if(nOne!=one)
				poss=false;
			out.println(poss?"POSSIBLE":"IMPOSSIBLE");
		}
		// ------------------------
		out.close();
	}
	//------------------------
	private static int dfs(String s){
		int num=1;
		used.put(s,true);
		for(String t:graph.get(s))
			if(!used.get(t))
				num+=dfs(t);
		return num;
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
