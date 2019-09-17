package backtracking;
import java.util.*;
import static java.lang.Math.*;

public class Pinemi2 {
	private static int n = 10, m = 10, def = 0, sum = 10, max = 3;
	private static int[][] board, rFree, cFree;
	private static int[] rSums, cSums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		for(int t = 0; t < p; t++){
			board = new int[n][m];
			rFree = new int[n][m];
			cFree = new int[n][m];
			rSums = new int[n];
			cSums = new int[m];
			System.out.println(sc.nextInt());
			initialize(sc);
			backtrack(0, 0);
			display();
		}
	}
	private static void initialize(Scanner sc) {
		for(int r = 0; r < n; r++)
			rSums[r] = sum;
		for(int c = 0; c < m; c++)
			cSums[c] = sum;
		for(int r = 0; r < n; r++)
			for(int c = 0; c < m; c++) {
				board[r][c] = -sc.nextInt();
				if(board[r][c] == 1)
					board[r][c] = def;
			}
		for(int r = n - 1; r >= 0; r--)
			for(int c = n - 1; c >= 0; c--) {
				if(r < n - 1)
					cFree[r][c] = cFree[r + 1][c] + (board[r + 1][c] == def ? 1 : 0);
				if(c < m - 1)
					rFree[r][c] = rFree[r][c + 1] + (board[r][c + 1] == def ? 1 : 0);
			}
	}
	private static boolean backtrack(int r, int c) {
		if(r == n)
			return true;
		int rI = r + (c + 1) / m, cI = (c + 1) % m;
		if(board[r][c] != def)
			return backtrack(rI, cI);
		for(int x = minX(r, c); stillWorks(r, c, x); x++) {
			board[r][c] = x;
			if(locallyValid(r, c)) {
				rSums[r] -= x;
				cSums[c] -= x;
				if(backtrack(rI, cI))
					return true;
				rSums[r] += x;
				cSums[c] += x;
			}
		}
		board[r][c] = def;
		return false;
	}
	private static int minX(int r, int c) { //method relies on assumption of 1 to max as values for x
		return max(1, max(rSums[r] - rFree[r][c] * max, cSums[c] - cFree[r][c] * max));
	}
	private static boolean stillWorks(int r, int c, int x) { //method relies on assumption of 1 to max as values for x
		return x <= max && rSums[r] - x >= rFree[r][c] && cSums[c] - x >= cFree[r][c];
	}
	static int[] dx = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
	private static boolean locallyValid(int r, int c) {
		for(int i = 0; i < 8; i++)
			if(bad(r + dx[i], c + dy[i]))
				return false;
		return true;
	}
	static boolean bad(int r, int c) {
		if(!valid(r, c) || board[r][c] >= 0)
			return false;
		int sum = 0, free = 0;
		for(int i = 0; i < 8; i++)
			if(valid(r + dx[i], c + dy[i])) {
				int x = board[r + dx[i]][c + dy[i]];
				if(x == 0)
					free++;
				else if(x > 0)
					sum += x;
			}
		return !(sum + free <= -board[r][c] && sum + max * free >= -board[r][c]);
	}
	private static void display() {
		for(int[] r : board) {
			for(int x : r)
				System.out.printf("%3d", abs(x));
			System.out.println();
		}
	}
	private static boolean valid(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
