package templates;
import java.util.*;
import static java.lang.Math.*;

public class Maxflow {
	static ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
	static int[] par, f;
	static int[][] cap;
	static int N; //number of nodes in flow graph
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//sample implementation is for bipartite matching
		int n = sc.nextInt(), m = sc.nextInt();
		initialize(n + 2);//fill in N value
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
			if(u % 2 == 0)//u is in first partite set - CHANGE IF CONDITION
				addDirEdge(u, v, 1);
			else
				addDirEdge(v, u, 1);
		}
		for(int u = 0; u < n; u++)
			if(u % 2 == 0)//u is in first partite set - CHANGE IF CONDITION
				addDirEdge(n, u, 1);
			else
				addDirEdge(u, n + 1, 1);
		sc.close();
		System.out.println(maxflow(n, n + 1)); //need to change s/t ? 
	}
	static void initialize(int x) {
		N = x;
		par = new int[N];
		f = new int[N];
		cap = new int[N][N];
		for(int i = 0; i < N; i++)
			graph.add(new HashSet<Integer>());
	}
	static void addDirEdge(int u, int v, int w) {
		cap[u][v] += w;
		graph.get(u).add(v);
		graph.get(v).add(u);
	}
	static int maxflow(int s, int t) {
		int flow = 0, newFlow;
		while((newFlow = bfs(s, t)) != 0) {
			flow += newFlow;
			int node = t;
			while(node != s) {
				cap[par[node]][node] -= newFlow;
				cap[node][par[node]] += newFlow;
				node = par[node];
			}
		}
		return flow;
	}
	static int bfs(int s, int t) {
		for(int i = 0; i < N; i++)
			par[i] = -1;
		boolean[] used = new boolean[N];
		f[s] = Integer.MAX_VALUE;
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(s);
		while(!q.isEmpty()) {
			int i = q.pollFirst();
			if(!used[i]) {
				used[i] = true;
				for(int j : graph.get(i))
					if(par[j] == -1 && cap[i][j] > 0) {
						par[j] = i;
						f[j] = min(cap[i][j], f[i]);
						if(j == t)
							return f[j];
						q.add(j);
					}
			}
		}
		return 0;
	}
}
