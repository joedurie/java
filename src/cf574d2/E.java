package cf574d2;
import java.io.*;
import java.util.*;

public class E{
	// ------------------------
	static int[][]segtree,grid;
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// ------------------------
		int n=sc.nextInt(),m=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt();
		int n2=(int)Math.pow(2,Math.ceil(Math.log(n)/Math.log(2))),
				m2=(int)Math.pow(2,Math.ceil(Math.log(m)/Math.log(2)));
		long g=sc.nextLong(),x=sc.nextLong(),y=sc.nextLong(),z=sc.nextLong();
		grid=new int[n2][m2];
		for(int i=0;i<n*m;i++){
			grid[i/m][i%m]=(int)g;
			g=(g*x+y)%z;
		}
		segtree=new int[2*n2][2*m2];
		fillSegtree(1,1,0,n2-1,0,m2-1);
		long sum=0;
		for(int i=0;i<=n-a;i++)
			for(int j=0;j<=m-b;j++){
				long temp=RMQ(1,1,0,n2-1,0,m2-1,i,i+a-1,j,j+b-1);
				//System.out.println(i+" "+j+" "+temp);
				sum+=temp;
			}
		//out.println(n+" "+m+" "+n2+" "+m2);
		out.println(sum);
		// ------------------------
		out.close();
	}
	//------------------------
	static long RMQ(int i,int j,int iL,int iR,int jL,int jR,int qiL,int qiR,int qjL,int qjR){
		//System.out.println(iL+", "+jL+" x "+iR+", "+jR+" "+i+"/"+j);
		int iM=(iL+iR)/2, jM=(jL+jR)/2;
		if(qiL>iR||qiR<iL||qjL>jR||qjR<jL){
			//System.out.println("X");
			return Long.MAX_VALUE;
		}
		if(qiL<=iL&&qiR>=iR&&qjL<=jL&&qjR>=jR)
			return segtree[i][j];
		if(iL==iR)
			return Math.min(RMQ(i,2*j,iL,iR,jL,jM,qiL,qiR,qjL,qjR),RMQ(i,2*j+1,iL,iR,jM+1,jR,qiL,qiR,qjL,qjR));
		if(jL==jR)
			return Math.min(RMQ(2*i,j,iL,iM,jL,jR,qiL,qiR,qjL,qjR),RMQ(2*i+1,j,iM+1,iR,jL,jR,qiL,qiR,qjL,qjR));
		return Math.min(
				Math.min(RMQ(2*i,2*j,iL,iM,jL,jM,qiL,qiR,qjL,qjR),RMQ(2*i+1,2*j+1,iM+1,iR,jM+1,jR,qiL,qiR,qjL,qjR)),
				Math.min(RMQ(2*i,2*j+1,iL,iM,jM+1,jR,qiL,qiR,qjL,qjR),RMQ(2*i+1,2*j,iM+1,iR,jL,jM,qiL,qiR,qjL,qjR)));
	}
	static int fillSegtree(int i,int j,int iL,int iR,int jL,int jR){
		int iM=(iL+iR)/2, jM=(jL+jR)/2;
		if(iL==iR&&jL==jR)
			segtree[i][j]=grid[iL][jL];
		else if(iL==iR)
			segtree[i][j]=
			Math.min(fillSegtree(i,2*j,iL,iR,jL,jM),fillSegtree(i,2*j+1,iL,iR,jM+1,jR));
		else if(jL==jR)
			segtree[i][j]=
			Math.min(fillSegtree(2*i,j,iL,iM,jL,jR),fillSegtree(2*i+1,j,iM+1,iR,jL,jR));
		else segtree[i][j]=Math.min(
				Math.min(fillSegtree(2*i,2*j+1,iL,iM,jM+1,jR),fillSegtree(2*i+1,2*j,iM+1,iR,jL,jM)),
						Math.min(fillSegtree(2*i,2*j,iL,iM,jL,jM),fillSegtree(2*i+1,2*j+1,iM+1,iR,jM+1,jR)));
		//System.out.println(iL+", "+jL+" x "+iR+", "+jR+": "+i+"/"+j+" "+segtree[i][j]);
		return segtree[i][j];
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
