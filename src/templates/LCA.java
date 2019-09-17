package templates;
import java.util.*;
import static java.lang.Math.*;

public class LCA {
	private static ArrayList<HashSet<Integer>> tree = new ArrayList<HashSet<Integer>>();
	private static int[][] par;
	private static int[] dist;
	private static int n, logn;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        logn = (int) ceil(log(n) / log(2));
		for(int i = 0; i < n; i++)
			tree.add(new HashSet<Integer>());
		for(int i = 0; i < n - 1; i++){
			int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		par = new int[n][logn];
		dist = new int[n];
		fillPar(0, 0, 0);
	}
	private static void fillPar(int a, int p, int d) {
		dist[a] = d;
		par[a][0] = p;
		for(int i = 1; i < log(n); i++)
			par[a][i] = par[par[a][i - 1]][i - 1];
		for(int i : tree.get(a))
			if(i != p)
				fillPar(i, a, d + 1);
	}
	private static int lca(int a, int b) {
		int c = dist[a] > dist[b] ? a : b;
		int d = dist[a] > dist[b] ? b : a;
		for(int i = logn - 1; i >= 0; i--)
			if(dist[c] - dist[d] >= 1 << i)
				c = par[c][i];
		if(c == d)
			return c;
		for(int i = logn - 1; i >= 0; i--)
			if(par[c][i] != par[d][i]) {
				c = par[c][i];
				d = par[d][i];
			}
		return par[c][0];
	}
}
