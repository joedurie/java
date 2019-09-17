package backtracking;
import java.util.*;

public class RegularSudoku{
	private static int n=9,m=9,l=9,maxVal=9,def=0,inputDef=0;//FILL IN VALUES
	private static int[][]board;
	private static ArrayList<HashSet<Integer>>rows;
	private static ArrayList<HashSet<Integer>>cols;
	private static ArrayList<HashSet<Integer>>rects;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int t=0;t<p;t++){
			board=new int[n][m];
			rows=new ArrayList<HashSet<Integer>>();
			cols=new ArrayList<HashSet<Integer>>();
			rects=new ArrayList<HashSet<Integer>>();
			initialize(sc);
			long start=System.nanoTime();
			backtrack(new Square(0,0));
			display();
			System.out.println((System.nanoTime()-start)/1000000000.0);
		}
	}
	private static void initialize(Scanner sc){
		for(int r=0;r<n;r++)
			rows.add(allVals());
		for(int c=0;c<m;c++)
			cols.add(allVals());
		for(int w=0;w<l;w++)
			rects.add(allVals());
		sc.nextLine();
		for(int r=0;r<n;r++)
			for(int c=0;c<m;c++){
				board[r][c]=sc.nextInt();
				if(board[r][c]==inputDef)
					board[r][c]=def;
				rows.get(r).remove(board[r][c]);//do you need to check for true/false here?
				cols.get(c).remove(board[r][c]);
				rects.get(new Square(r,c).rect()).remove(board[r][c]);
			}
	}
	private static boolean backtrack(Square s){
		if(s.r==n)
			return true;
		HashSet<Integer>vals=ok(s);
		if(board[s.r][s.c]!=def)
			return backtrack(s.inc());
		for(int x:vals){
			board[s.r][s.c]=x;
			rows.get(s.r).remove(x);
			cols.get(s.c).remove(x);
			rects.get(s.rect()).remove(x);
			if(backtrack(s.inc()))	
				return true;
			rows.get(s.r).add(x);
			cols.get(s.c).add(x);
			rects.get(s.rect()).add(x);
		}
		board[s.r][s.c]=def;
		return false;
	}
	private static void display(){
		for(int[]r:board){
			for(int x:r)
				System.out.print(x+" ");
			System.out.println();
		}
	}
	private static HashSet<Integer>allVals(){
		HashSet<Integer>set=new HashSet<Integer>();
		for(int i=1;i<=maxVal;i++)//1 to max range correct?
			set.add(i);
		return set;
	}
	private static HashSet<Integer>ok(Square s){//change if rows/cols/rects different
		HashSet<Integer>set=new HashSet<Integer>();
		for(int x:rows.get(s.r))
			if(cols.get(s.c).contains(x)&&rects.get(s.rect()).contains(x))
				set.add(x);
		return set;
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
		private int rect(){
			return r/3+3*(c/3);
		}
		private boolean valid(){
			return r>=0&&c>=0&&r<n&&c<m;
		}
		public String toString(){
			return "("+r+","+c+")";
		}
	}
}
