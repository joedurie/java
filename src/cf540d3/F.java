package cf540d3;
import java.util.*;
public class F {
	private static HashMap<Integer,HashSet<Integer>>tree=new HashMap<Integer,HashSet<Integer>>();
	private static int[]color;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		color=new int[n];
		for(int i=0;i<n;i++)
			color[i]=sc.nextInt();
		for(int i=0;i<n;i++)
			tree.put(i,new HashSet<Integer>());
		for(int i=0;i<n-1;i++){
			int u=sc.nextInt()-1,v=sc.nextInt()-1;
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		sc.close();
		int[]res=getRB(0,-1);
	}
	private static int[]getRB(int i,int p){
		int[]ans=new int[6];
		for(int j:tree.get(i))
			if(j!=p){
				int[]temp=getRB(j,i);
				
			}
	}
}
