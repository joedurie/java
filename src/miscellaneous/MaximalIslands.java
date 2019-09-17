package miscellaneous;
import java.util.*;

public class MaximalIslands {
	static ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
	static int[] par, f;
	static int[][] cap;
	static int n, m;
	static int N;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static char[][] grid;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		initialize(n * m + 2);
		sc.nextLine();
		grid = new char[n][m];
		for(int i = 0; i < n; i++)
			grid[i] = sc.nextLine().toCharArray();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				for(int k = 0; k < 4; k++){
					int nI = i + dx[k], nJ = j + dy[k]; 
					if(valid(nI, nJ) && grid[i][j] == 'C' && grid[nI][nJ] == 'L')
						grid[i][j] = 'W';
				}
		int islands = 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				if(grid[i][j] == 'L') {
					islands++;
					flood(i, j);
				}
		int cloudCt = 0;
		for(int i = 0; i < n; i++)
			for(int j = i % 2; j < m; j += 2)
				if(grid[i][j] == 'C') {
					cloudCt++;
					addDirEdge(n * m, i * m + j, 1);
					for(int k = 0; k < 4; k++){
						int nI = i + dx[k], nJ = j + dy[k]; 
						if(valid(nI, nJ) && grid[nI][nJ] == 'C')
							addDirEdge(i * m + j, nI * m + nJ, 1);
					}
				}
		for(int i = 0; i < n; i++)
			for(int j = 1 - i % 2; j < m; j += 2)
				if(grid[i][j] == 'C') {
					cloudCt++;
					addDirEdge(i * m + j, n * m + 1, 1);
				}
		sc.close();
		System.out.println(islands + cloudCt - maxflow(n * m, n * m + 1)); //need to change s/t ? 
	}
	static boolean valid(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}
	static void flood(int i, int j) {
		if(valid(i, j) && grid[i][j] == 'L') {
			grid[i][j] = 'W';
			for(int k = 0; k < 4; k++)
				flood(i + dx[k], j + dy[k]);
		}
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
