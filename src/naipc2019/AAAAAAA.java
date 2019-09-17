package naipc2019;
import java.util.*;
public class AAAAAAA {
	private static HashMap<Integer,HashSet<Integer>>tree=new HashMap<Integer,HashSet<Integer>>();
	private static long[] val;
	private static double prob=1;
	private static long MOD=1000000007;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
			tree.put(i,new HashSet<Integer>());
		val=new long[n];
		int root=-1;
		for(int i=0;i<n;i++){
			long a=sc.nextLong();
			int p=sc.nextInt();
			if(p==0)
				root=i;
			else
				tree.get(p).add(i);
			val[i]=a;
		}
		sc.close();
		dfs(0);
	}
	private static void dfs(int i){
		for(int j:tree.get(i)){
			prob*=
			dfs(j);
		}
	}
	private static long pow(int a,int p){
		if(p==1)
			return a;
		long x=pow(a,p/2);
		return ((x*x)%MOD*(p%2==1?a:1))%MOD;
	}
}
