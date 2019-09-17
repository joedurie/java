package miscellaneous;
import java.util.*;
public class PT07Z {
	private static TreeMap<Integer,TreeSet<Integer>>graph=new TreeMap<Integer,TreeSet<Integer>>();
	private static boolean[]used;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n-1;i++){
			int a=sc.nextInt()-1,b=sc.nextInt()-1;
			if(!graph.containsKey(a))
				graph.put(a,new TreeSet<Integer>());
			graph.get(a).add(b);
			if(!graph.containsKey(b))
				graph.put(b,new TreeSet<Integer>());
			graph.get(b).add(a);
		}
		used=new boolean[n];
		System.out.println(maxL(maxL(0,false)[1],true)[0]);
		sc.close();
	}
	public static int[] maxL(int start, boolean b){
		used[start]=!b;
		int max=0;
		int node=start;
		for(int i:graph.get(start))
			if(used[i]==b){
				int[]ln=maxL(i,b);
				if(ln[0]+1>max){
					max=ln[0]+1;
					node=ln[1];
				}
			}
		int[]arr={max,node};
		return arr;
	}
}