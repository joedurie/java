package backtracking;
import java.util.*;
public class Pinemi {
	private static int n=10,m=10;
	private static int[][]board;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int t=0;t<p;t++){
			board=new int[n][m];
			System.out.println(sc.nextInt());
			readInput(sc);
			backtrack(new Square(0,0),true);
			display();	
		}
	}
	private static boolean backtrack(Square s,boolean forward){
		if(s.r==-1)
			return false;
		if(s.r==n)
			return true;
		if(board[s.r][s.c]>0){
			if(forward)
				return backtrack(s.inc(),true);
			return backtrack(s.dec(),false);
		}
		board[s.r][s.c]--;
		if(board[s.r][s.c]==-4){
			board[s.r][s.c]=0;
			return backtrack(s.dec(),false);
		}
		if(!valid(s))
			return backtrack(s,true);
		return backtrack(s.inc(),true);
	}
	private static boolean valid(Square s){
		int colSum=0,empCol=0;
		for(int r=0;r<n;r++)
			if(board[r][s.c]<0)
				colSum-=board[r][s.c];
			else if(board[r][s.c]==0)
				empCol++;
		int rowSum=0,empRow=0;
		for(int c=0;c<m;c++)
			if(board[s.r][c]<0)
				rowSum-=board[s.r][c];
			else if(board[s.r][c]==0)
				empRow++;
		if(colSum>10||rowSum>10)
			return false;
		if(colSum+empCol>10||rowSum+empRow>10)
			return false;
		if(colSum+empCol*3<10||rowSum+empRow*3<10)
			return false;
		HashSet<Square>sAdj=s.adj();
		for(Square t:sAdj)
			if(board[t.r][t.c]>0){
				int sum=0,emp=0;
				HashSet<Square>tAdj=t.adj();
				for(Square q:tAdj)
					if(board[q.r][q.c]<0)
						sum-=board[q.r][q.c];
					else if(board[q.r][q.c]==0)
						emp++;
				if(sum>board[t.r][t.c])
					return false;
				if(sum+emp>board[t.r][t.c])
					return false;
				if(sum+3*emp<board[t.r][t.c])
					return false;
			}
		return true;
	}
	private static void readInput(Scanner sc){
		for(int r=0;r<n;r++)
			for(int c=0;c<m;c++)
				board[r][c]=Math.max(sc.nextInt(),0);
	}
	private static void display(){
		for(int[]r:board){
			for(int x:r)
				System.out.printf("%3d",Math.abs(x));
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
		private HashSet<Square>adj(){
			HashSet<Square>set=new HashSet<Square>();
			int[]dr={-1,-1,-1,0,0,1,1,1};
			int[]dc={-1,0,1,-1,1,-1,0,1};
			for(int i=0;i<8;i++){
				Square s=new Square(r+dr[i],c+dc[i]);
				if(s.valid())
					set.add(s);
			}
			return set;
		}
		private boolean valid(){
			return r>=0&&c>=0&&r<n&&c<m;
		}
		public String toString(){
			return "("+r+","+c+"): "+board[r][c];
		}
	}
}
