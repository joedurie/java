package miscellaneous;
import java.util.*;
public class SuspiciousBugs {
	private static boolean[][]edge;
	private static boolean sbf;
	private static int[]gender;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
			int n=sc.nextInt();
			int x=sc.nextInt();
			edge=new boolean[n][n];
			sbf=false;
			gender=new int[n];
			for(int j=0;j<x;j++){
				int a=sc.nextInt()-1,b=sc.nextInt()-1;
				edge[a][b]=true;
				edge[b][a]=true;
			}
			for(int k=0;k<n;k++)
				if(gender[k]==0)
					dfs(k,1);
			System.out.println("Scenario #"+(i+1)+":");
			System.out.println((sbf?"S":"No s")+"uspicious bugs found!");
		}
		sc.close();
	}
	public static void dfs(int r,int g){
		if(!sbf){
			gender[r]=g;
			for(int i=0;i<gender.length;i++)
				if(edge[r][i]){
					if(gender[i]==0)
						dfs(i,3-g);
					else if(gender[i]==gender[r])
						sbf=true;
				}
		}
	}
}