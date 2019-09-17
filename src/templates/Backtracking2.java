package templates;
import java.util.*;
import static java.lang.Math.*;

public class Backtracking2 {
	private static int n = -1, m = -1, def = -1, sum = -1, max = -1;//FILL IN VALUES
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
			System.out.println(sc.nextInt());//test case number
			initialize(sc);
			boolean b = backtrack(0, 0);//need to handle b false?
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
				board[r][c] = sc.nextInt();
				rSums[r] -= board[r][c];
				cSums[c] -= board[r][c];
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
	//following 2 methods rely on assumption of 1 to max as values for x
	private static int minX(int r, int c) {
		return max(1, max(rSums[r] - rFree[r][c] * max, cSums[c] - cFree[r][c] * max));
	}
	private static boolean stillWorks(int r, int c, int x) {
		return x <= max && rSums[r] - x >= rFree[r][c] && cSums[c] - x >= cFree[r][c];
	}
	private static boolean locallyValid(int r, int c) {
		return true;//IMPLEMENT
	}
	private static void display() {
		for(int[] r : board) {
			for(int x : r)
				System.out.print(x + " ");
			System.out.println();
		}
	}
	private static boolean valid(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
