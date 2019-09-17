package upsolves;
import java.util.*;
import static java.lang.Math.*;

public class Checkers {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		char[][] grid = new char[n][];
		for(int i = 0; i < n; i++)
			grid[i] = sc.nextLine().toCharArray();
		sc.close();
		int wPar = -1, w = 0, vPar = grid[0][0] == '.' ? 1 : 0;
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(grid[i][j] == 'W') {
					w++;
					if(wPar == -1)
						wPar = i % 2;
					else if(wPar != i % 2 || i == 0 || j == 0 || i == n - 1 || j == n - 1)
						wPar = -2;
				}
		if(wPar == -2) {
			System.out.println("None");
			return;
		}
		String ans = "None";
		int[] dx = {2, 2, -2, -2}, dy = {2, -2, 2, -2};
		for(int x = 0; x <= 2; x+=2) {
			HashMap<String, LinkedList<String>> graph = new HashMap<String, LinkedList<String>>();
			HashSet<String> black = new HashSet<String>();
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					if(i % 2 == 1 - wPar && (i + j) % 4 == x) {
					if(grid[i][j] == 'B')
						black.add(str(i, j));
					graph.put(str(i, j), new LinkedList<String>());
					for(int k = 0; k < 4; k++)
						if(valid(i + dx[k], j + dy[k]) && grid[i + dx[k] / 2][j + dy[k] / 2] == 'W')
							graph.get(str(i, j)).add(str(i + dx[k], j + dy[k]));
					}
			for(String s : graph.keySet())
				System.out.println(s + " " + graph.get(s));
			boolean connected = false;
			HashSet<String> used = new HashSet<String>();
			for(String s : graph.keySet())
				if(!used.contains(s) && dfs(s, graph, used) == w)
					connected = true;
			if(!connected)
				continue;
			HashSet<String> odd = new HashSet<String>();
			TreeSet<String> covered = new TreeSet<String>();
			for(String s : graph.keySet()) {
				if(graph.get(s).size() % 2 == 1)
					odd.add(s);
				if(graph.get(s).size() > 0 && black.contains(s))
					covered.add(s);
			}
			if(odd.size() == 0 && covered.size() == 1)
				if(ans.equals("None"))
					ans = covered.first();
				else
					ans = "Multiple";
			if(odd.size() == 2 && covered.size() == 1 && odd.contains(covered.first()))
				if(ans.equals("None"))
					ans = covered.first();
				else
					ans = "Multiple";
		}
		System.out.println(ans);
	}
	static int dfs(String s, HashMap<String, LinkedList<String>> graph, HashSet<String> used) {
		used.add(s);
		int edges = 0;
		for(String t : graph.get(s))
			if(!used.contains(t))
				edges += 1 + dfs(t, graph, used);
		return edges;
	}
	static String str(int i, int j) {
		return (char)('a' + j) + "" + (n - i);
	}
	static boolean valid(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < n;
	}
}
