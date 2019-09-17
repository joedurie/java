package cfed58;
import java.util.*;
public class D {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[]a=new int[n];
		boolean b=false;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			if(a[i]!=1)
				b=true;
		}
		HashMap<Integer,HashSet<Integer>>tree=new HashMap<Integer,HashSet<Integer>>();
		for(int i=0;i<n-1;i++){
			int x=sc.nextInt()-1,y=sc.nextInt()-1;
			if(gcd(a[x],a[y])>1){
				if(!tree.containsKey(y))
					tree.put(y,new HashSet<Integer>());
				if(!tree.containsKey(x))
					tree.put(x,new HashSet<Integer>());
				tree.get(x).add(y);
				tree.get(y).add(x);
			}
		}
		boolean[]used=new boolean[n];
		int dist=0;
		for(int i=0;i<n;i++)
			if(!used[i])
				dist=Math.max(dist,dFrom(i,tree,used));
		System.out.println(dist==1?(b?1:0):dist);
		sc.close();
	}
	public static int gcd(int a,int b){
		if(a==b)
			return a;
		if(a==1||b==1)
			return 1;
		return gcd(Math.min(a, b),Math.max(a, b)-Math.min(a,b));
	}
	public static int dFrom(int i,HashMap<Integer,HashSet<Integer>>tree,boolean[]used){
		if(!tree.containsKey(i))
			return 1;
		used[i]=true;
		int max=1;
		for(int j:tree.get(i))
			if(!used[j])
				max=Math.max(max,1+dFrom(j,tree,used));
		return max;
	}
}