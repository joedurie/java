package backtracking;
import java.util.*;
public class Capsules2 {
	private static int n, m, l, def = 0;
	private static int[][] board, rect;
	private static long[] sMasks;
	private static int[] size;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		for(int t = 0; t < p; t++){
			System.out.println(sc.nextInt());
			n = sc.nextInt();
			m = sc.nextInt();
			board = new int[n][m];
			rect = new int[n][m];
			initialize(sc);
			boolean b = backtrack(0, 0);
			display();
		}
	}
	private static void initialize(Scanner sc) {
		sc.nextLine();
		for(int r = 0; r < n; r++) {
			String[] arr = sc.nextLine().replaceAll("-","0").split(" ");
			for(int c = 0; c < m; c++)
				board[r][c] = arr[c].charAt(0) - '0';
		}
		l = sc.nextInt();
		sMasks = new long[l];
		size = new int[l];
		for(int i = 0; i < l; i++){
			size[i] = sc.nextInt();
			sMasks[i] = (1 << (size[i] + 1)) - 1;
			String[] arr = sc.nextLine().trim().split(" ");
			for(int j = 0; j < size[i]; j++)
				rect[arr[j].charAt(1) - '1'][arr[j].charAt(3) - '1'] = i;
		}
		for(int r = 0; r < n; r++)
			for(int c = 0; c < m; c++)
				xorify(r, c, board[r][c]);
	}
	private static boolean backtrack(int r,int c) {
		if(r == n)
			return true;
		int rI = r + (c + 1) / m, cI = (c + 1) % m;
		if(board[r][c] != def)
			return backtrack(rI, cI);
		for(int x = 1; x <= size[rect[r][c]]; x++){
			if((sMasks[rect[r][c]] & (1 << x)) > 0 && locallyValid(r, c, x)) {
				board[r][c] = x;
				xorify(r, c, x);
				if(backtrack(rI, cI))
					return true;
				xorify(r, c, x);
			}
		}
		board[r][c] = def;
		return false;
	}
	private static boolean locallyValid(int r,int c, int x) {
		for(int dx = -1; dx <= 1; dx++)
			for(int dy = -1; dy <= 1; dy++)
				if(dx != 0 || dy != 0)
					if(valid(r + dx, c + dy) && board[r + dx][c + dy] == x)
						return false;
		return true;
	}
	private static void display() {
		for(int[] r : board) {
			String s = "";
			for(int x : r)
				s += x + " ";
			System.out.println(s.trim());
		}
	}
	private static void xorify(int r, int c, int x) {
		sMasks[rect[r][c]] ^= 1 << x;
	}
	private static boolean valid(int r, int c) {
		return r >= 0 && c >= 0 && r < n && c < m;
	}
}
