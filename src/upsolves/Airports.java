package upsolves;
import java.util.*;
import static java.lang.Math.*;

public class Airports {
	static ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
	static int[] par, f;
	static int[][] cap;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		initialize(2 * m + 2);
		int[][] d = new int[n][n];
		int[][] fT = new int[n][n];
		int[] p = new int[n];
		for(int i = 0; i < n; i++)
			p[i] = sc.nextInt();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				d[i][j] = fT[i][j] = sc.nextInt() + (i == j ? 0 : p[j]);
		for(int k = 0; k < n; k++)
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
		for(int i = 0; i < m; i++)
			addDirEdge(2 * m, i, 1);
		for(int i = m; i < 2 * m; i++)
			addDirEdge(i, 2 * m + 1, 1);
		int[][] flights = new int[m][];
		for(int i = 0; i < m; i++)
			flights[i] = new int[]{sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()};
		for(int i = 0; i < m; i++)
			for(int j = 0; j < m; j++)
				if(flights[i][2] + fT[flights[i][0]][flights[i][1]] + d[flights[i][1]][flights[j][0]] <= flights[j][2])
					addDirEdge(i, j + m, 1);
		sc.close();
		System.out.println(m - maxflow(2 * m, 2 * m + 1)); //need to change s/t ? 
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
						f[j] = Math.min(cap[i][j], f[i]);
						if(j == t)
							return f[j];
						q.add(j);
					}
			}
		}
		return 0;
	}
}

