package Oct18KS;
import java.util.*;
import java.io.*;
public class C{
	static int[][]grid;
	static long[][]strArr;
	static boolean[][]visited;
	public static void main(String[]args) throws FileNotFoundException{
		Scanner sc=new Scanner(new File("C-small-attempt1.in"));
		PrintWriter out=new PrintWriter("C-small-attempt1.txt");
		int t=sc.nextInt();
		for(int i=1;i<=t;i++){
			int n=sc.nextInt(),m=sc.nextInt(),e=sc.nextInt();
			int sR=sc.nextInt()-1,sC=sc.nextInt()-1;
			int tR=sc.nextInt()-1,tC=sc.nextInt()-1;
			grid=new int[n][m];
			for(int r=0;r<n;r++)
				for(int c=0;c<m;c++)
					grid[r][c]=sc.nextInt();
			strArr=new long[n][m];
			for(int r=0;r<n;r++)
				Arrays.fill(strArr[r], -1);
			visited=new boolean[n][m];
			dfs(sR,sC,e);
			out.println("Case #"+i+": "+strArr[tR][tC]);
		}
		sc.close();
		out.close();
	}
	public static void dfs(int r,int c, long e){
		if(grid[r][c]!=-100000&&!visited[r][c]&&e+grid[r][c]>0){
			visited[r][c]=true;
			grid[r][c]=0;
			strArr[r][c]=grid[r][c]+e;
			if(r>0)
				dfs(r-1,c,strArr[r][c]);
			if(r<strArr.length-1)
				dfs(r+1,c,strArr[r][c]);
			if(c>0)
				dfs(r,c-1,strArr[r][c]);
			if(c<strArr[r].length-1)
				dfs(r,c+1,strArr[r][c]);
		}
	}
}
