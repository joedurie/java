package backtracking;
import java.util.*;
public class RegularSudoku2{
	private static int n=9,m=9,l=9,maxVal=9,def=0,inputDef=0;
	private static int[][]board;
	private static int[]rMasks;
	private static int[]cMasks;
	private static int[]sMasks;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int t=0;t<p;t++){
			board=new int[n][m];
			rMasks=new int[n];
			cMasks=new int[m];
			sMasks=new int[l];
			initialize(sc);
			long start=System.nanoTime();
			backtrack(new Square(0,0));
			display();
			System.out.println((System.nanoTime()-start)/1000000000.0);
		}
	}
	private static void initialize(Scanner sc){
		for(int r=0;r<n;r++)
			rMasks[r]=(1<<(n+1))-1;
		for(int c=0;c<m;c++)
			cMasks[c]=(1<<(m+1))-1;
		for(int w=0;w<l;w++)
			sMasks[w]=(1<<(l+1))-1;
		sc.nextLine();
		for(int r=0;r<n;r++)
			for(int c=0;c<m;c++){
				board[r][c]=sc.nextInt();
				if(board[r][c]==inputDef)
					board[r][c]=def;
				rMasks[r]^=1<<board[r][c];
				cMasks[c]^=1<<board[r][c];
				sMasks[rect(r,c)]^=1<<board[r][c];
			}
	}
	private static boolean backtrack(Square s){
		if(s.r==n)
			return true;
		if(board[s.r][s.c]!=def)
			return backtrack(s.inc());
		int mask=rMasks[s.r]&cMasks[s.c]&sMasks[rect(s.r,s.c)];
		for(int x=1;x<=maxVal;x++)
			if((mask&(1<<x))>0){
				rMasks[s.r]^=1<<x;
				cMasks[s.c]^=1<<x;
				sMasks[rect(s.r,s.c)]^=1<<x;
				if(backtrack(s.inc()))
					return true;
				rMasks[s.r]|=1<<x;
				cMasks[s.c]|=1<<x;
				sMasks[rect(s.r,s.c)]|=1<<x;
			}
		board[s.r][s.c]=def;
		return false;
	}
	private static int rect(int r,int c){
		return r/3+3*(c/3);
	}
	private static void display(){
		for(int[]r:board){
			for(int x:r)
				System.out.print(x+" ");
			System.out.println();
		}
	}
	private static class Square{
		int r,c;
		public Square(int R,int C){
			r=R;
			c=C;
		}
		private Square inc(){
			if(c+1==m)
				return new Square(r+1,0);
			return new Square(r,c+1);
		}
		private Square dec(){
			if(c-1==-1)
				return new Square(r-1,m-1);
			return new Square(r,c-1);
		}
		private boolean valid(){
			return r>=0&&c>=0&&r<n&&c<m;
		}
		public String toString(){
			return "("+r+","+c+")";
		}
	}
}
