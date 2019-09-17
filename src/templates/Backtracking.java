package templates;
import java.util.*;
import static java.lang.Math.*;

public class Backtracking {
	private static int n = -1, m = -1, l = -1, maxVal = -1, def = -1;//FILL IN VALUES
	private static int[][] board;
	private static int[] rMasks, cMasks, sMasks;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		for(int t = 0; t < p; t++){
			board = new int[n][m];
			rMasks = new int[n];
			cMasks = new int[m];
			sMasks = new int[l];
			System.out.println(sc.nextInt());//test case number
			initialize(sc);
			boolean b = backtrack(0, 0);//need to handle b false?
			display();
		}
	}
	private static void initialize(Scanner sc) {
		for(int r = 0; r < n; r++)
			rMasks[r] = (1 << (maxVal + 1)) - 1;//is maxVal the right value here?
		for(int c = 0; c < m; c++)
			cMasks[c] = (1 << (maxVal + 1)) - 1;
		for(int w = 0; w < l; w++)
			sMasks[w] = (1 << (maxVal + 1)) - 1;
		for(int r = 0; r < n; r++)
			for(int c = 0; c < m; c++) {
				board[r][c] = sc.nextInt();
				xorify(r, c, board[r][c]);
			}
	}
	private static boolean backtrack(int r, int c) {
		if(r == n)
			return true;
		int rI = r + (c + 1) / m, cI = (c + 1) % m;
		if(board[r][c] != def)
			return backtrack(rI, cI);
		int mask = rMasks[r] & cMasks[c] & sMasks[rect(r, c)];
		for(int x = 1; (1 << x) <= mask; x++)
			if((mask & (1 << x)) > 0) {
				board[r][c] = x;
				if(locallyValid(r, c)) {
					xorify(r, c, x);
					if(backtrack(rI, cI))
						return true;
					xorify(r, c, x);
				}
			}
		board[r][c] = def;
		return false;
	}
	private static boolean locallyValid(int r, int c) {
		return true;//IMPLEMENT
	}
	private static int rect(int r, int c) {
		return -1;//IMPLEMENT
	}
	private static void display() {
		for(int[] r : board) {
			for(int x : r)
				System.out.print(x + " ");
			System.out.println();
		}
	}
	private static void xorify(int r, int c, int x) {
		rMasks[r] ^= 1 << x;
		cMasks[c] ^= 1 << x;
		sMasks[rect(r, c)] ^= 1 << x;
	}
	private static boolean valid(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
