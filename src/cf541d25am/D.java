package cf541d25am;
import java.util.*;
import java.io.*;

public class D {
	// ------------------------

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),m=sc.nextInt();
		int[]badN=new int[n];
		int[]badM=new int[m];
		int[]set=new int[n+m];
		for(int i=0;i<n+m;i++)
			set[i]=i;
		char[][]grid=new char[n][m];
		for(int i=0;i<n;i++){
			grid[i]=sc.nextLine().toCharArray();
			for(int j=0;j<grid[i].length;j++)
				if(grid[i][j]=='<')
					badN[i]++;
				else if(grid[i][j]=='>')
					badM[j]++;
				else if(set[i]==i)
					set[i]=set[j+n];
				else
					set[j+n]=set[i];
		}
		for(int i=0;i<n+m;i++)
			while(set[i]!=set[set[i]])
				set[i]=set[set[i]];
		boolean poss=true;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(set[i]==set[j+n]&&grid[i][j]!='=')
					poss=false;
		int goneN=0,goneM=0;
		int[]scoreN=new int[n];
		int[]scoreM=new int[m];
		int score=0;
		boolean[]usedN=new boolean[n];
		boolean[]usedM=new boolean[m];
		//boolean possEQ=true;
		while(goneN+goneM<n+m&&poss){//&&possEQ){
			poss=false;
			int gNT=0,gMT=0;
			//int eqN0=-1,eqM0=-1;
			for(int i=0;i<n;i++)
				if(badN[i]<=goneM&&!usedN[i]){
					scoreN[i]=score;
					usedN[i]=true;
					gNT++;
					poss=true;
					/*if(eqN0==-1)
						eqN0=eqN[i];
					else if(eqN0!=eqN[i])
						possEQ=false;*/
				}
			for(int j=0;j<m;j++)
				if(badM[j]<=goneN&&!usedM[j]){
					scoreM[j]=score;
					usedM[j]=true;
					gMT++;
					poss=true;
					/*if(eqM0==-1)
						eqM0=eqM[j];
					else if(eqM0!=eqM[j])
						possEQ=false;*/
				}
			goneN+=gNT;
			goneM+=gMT;
			//if(eqM0!=gNT||eqN0!=gMT)
				//possEQ=false;
			score++;
		}
		out.println(poss?"Yes":"No");//&&possEQ
		if(poss){//&&possEQ){
			for(int i=0;i<n;i++)
				out.print(score-scoreN[i]+" ");
			out.println();
			for(int j=0;j<m;j++)
				out.print(score-scoreM[j]+" ");
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
