package miscellaneous;
import java.util.*;

public class BuggyRobot {
	static int n, m;
	static char[][] grid;
	static int[][] aaaaa;
	static int[][] dist;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static String str = "UDRL";
	static LinkedList<Integer> llx = new LinkedList<Integer>();
	static LinkedList<Integer> lly = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		grid = new char[n][];
		aaaaa = new int[n][m];
		for(int i = 0; i < n; i++)
			grid[i] = sc.nextLine().toCharArray();
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				aaaaa[i][j] = grid[i][j] == 'R' ? 0 : 1000000;
				if(grid[i][j] == 'E')
			}
		char[] s = sc.nextLine().toCharArray();
		sc.close();
		int ans = Integer.MAX_VALUE;
		for(char c : s) {
			int k = str.indexOf(c);
			int[][] bbbbb = new int[n][m];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					if(valid(i + dx[k], j + dy[k]) && grid[i + dx[k]][j + dy[k]] != '#')
						bbbbb[i + dx[k]][j + dx[k]] = aaaaa[i][j];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					aaaaa[i][j] = Math.min(aaaaa[i][j] + 1, bbbbb[i][j]);
		}
	}
	static boolean valid(int i, int j) {
		return i >= 0 && j >= 0 && i < n && j < m;
	}
}
