package northwesticpc2017;
import java.util.*;

public class J {
	private static int n, m;
	private static long ct = 0;
	private static int[][] board;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][m];
		initialize(sc);
		backtrack(0, 0);
		System.out.println(ct);
	}
	private static void initialize(Scanner sc) {
		sc.nextLine();
		for(int r = 0; r < n; r++) {
			char[] line = sc.nextLine().toCharArray();
			for(int c = 0; c < m; c++) 
				if(line[c] == 'B')
					board[r][c] = 2;
				else if(line[c] == 'R')
					board[r][c] = 1;
		}
	}
	private static void backtrack(int r, int c) {
		if(r == n) {
			ct++;
			return;
		}
		int rI = r + (c + 1) / m, cI = (c + 1) % m;
		if(board[r][c] != 0) {
			backtrack(rI, cI);
			return;
		}
		for(int x = 1; x <= 2; x++) {
			board[r][c] = x;
			if(locallyValid(r, c))
				backtrack(rI, cI);
		}
		board[r][c] = 0;
	}
	private static boolean locallyValid(int r, int c) {
		for(int i = c - 1; i <= c; i++)
			if(valid(r, i) && valid(r, i + 1) && board[r][i] == 1 && board[r][i + 1] == 2)
				return false;
		for(int i = r - 1; i <= r; i++)
			if(valid(i, c) && valid(i + 1, c) && board[i][c] == 1 && board[i + 1][c] == 2)
				return false;
		return true;
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

