package codejam20192;
import java.util.*;
public class D {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int cases=sc.nextInt();
		for(int caseNum=1;caseNum<=cases;caseNum++){
			int m=sc.nextInt();
			HashMap<Integer,ArrayList<Integer>>graph=new HashMap<Integer,ArrayList<Integer>>();
			HashMap<Integer,HashSet<Integer>>revGraph=new HashMap<Integer,HashSet<Integer>>();
			for(int i=0;i<m;i++){
				graph.put(i,new ArrayList<Integer>());
				revGraph.put(i, new HashSet<Integer>());
			}
			HashSet<Integer>selfloops=new HashSet<Integer>();
			for(int i=0;i<m;i++){
				graph.get(i).add(sc.nextInt());
				graph.get(i).add(sc.nextInt());
				if(graph.get(i).contains(i))
					selfloops.add(i);
				for(int x:graph.get(i))
					revGraph.get(x).add(i);
			}
			boolean[]unb=new boolean[m];
			for(int i:selfloops)
				dfs(unb,i,revGraph);
			int[]g=new int[m];
			for(int i=0;i<m;i++)
				g[i]=sc.nextInt();
			System.out.println("Case #"+caseNum+": ");
		}
	}
	public static void dfs(boolean[]unb,int i,HashMap<Integer,HashSet<Integer>>graph){
		if(!unb[i]){
			unb[i]=true;
			for(int j:graph.get(i))
				dfs(unb,j,graph);
		}
	}
}
