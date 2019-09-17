package backtracking;
import java.util.*;
public class SumdokuTwo {
	private static int n = 9, m = 9, l = 9, maxVal = 9, def = 0;//FILL IN VALUES
	private static int[][] board;
	private static int[] rMasks, cMasks, sMasks;
	private static char[][]up,lf;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		for(int t = 0; t < p; t++){
			board = new int[n][m];
			up=new char[n][m];
			lf=new char[n][m];
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
		sc.nextLine();
		int[]lfCs=new int[]{1,2,4,5,7,8};
		for(int i=0;i<15;i++){
			char[]s=sc.nextLine().toCharArray();
			int row=3*(i/5)+((i%5)+1)/2;
			if((i%5)%2==0)
				for(int j=0;j<6;j++)
					lf[row][lfCs[j]]=s[j];
			else
				for(int j=0;j<9;j++)
					up[row][j]=s[j];
		}
	}
	private static boolean backtrack(int r, int c) {
		if(r == n)
			return true;
		int rI = r + (c + 1) / m, cI = (c + 1) % m;
		int mask = rMasks[r] & cMasks[c] & sMasks[rect(r, c)];
		for(int x = 1; x <= maxVal; x++)
			if((mask & (1 << x)) > 0 && locallyValid(r, c, x)) {
				board[r][c] = x;
				xorify(r, c, x);
				if(backtrack(rI, cI))
					return true;
				xorify(r, c, x);
			}
		board[r][c] = def;
		return false;
	}
	private static boolean locallyValid(int r, int c, int x) {
		if(up[r][c]=='>'&&board[r-1][c]+x<=10)
			return false;
		if(up[r][c]=='<'&&board[r-1][c]+x>=10)
			return false;
		if(up[r][c]=='='&&board[r-1][c]+x!=10)
			return false;
		if(lf[r][c]=='>'&&board[r][c-1]+x<=10)
			return false;
		if(lf[r][c]=='<'&&board[r][c-1]+x>=10)
			return false;
		if(lf[r][c]=='='&&board[r][c-1]+x!=10)
			return false;
		return true;
	}
	private static int rect(int r, int c) {
		return 3*(r/3)+(c/3);
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
