package backtracking;
import java.util.*;
public class TicTacLogic{
	private static int n,m,def=-1,inputDef=0;//FILL IN VALUES
	private static int[][]board;
	private static int[]rowsX,rowsO,colsX,colsO;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int t=0;t<p;t++){
			n=sc.nextInt();
			m=n;
			board=new int[n][m];
			rowsX=new int[n];
			colsX=new int[m];
			rowsO=new int[n];
			colsO=new int[m];
			System.out.println(sc.nextInt());//test case number
			initialize(sc);
			boolean b=backtrack(new Square(0,0));//need to handle b false?
			display();
		}
	}
	private static void initialize(Scanner sc){
		for(int i=0;i<n;i++){
			rowsX[i]=n/2;
			rowsO[i]=n/2;
			colsX[i]=n/2;
			colsO[i]=n/2;
		}
		sc.nextLine();
		for(int r=0;r<n;r++)
			for(int c=0;c<m;c++){
				board[r][c]=sc.nextInt()-1;
				fixRC(r,c);
			}
	}
	private static void fixRC(int r,int c){
		if(board[r][c]==0){
			rowsO[r]--;
			colsO[c]--;
		}else if(board[r][c]==1){
			rowsX[r]--;
			colsX[c]--;
		}
	}
	private static int val(int r,int c){
		return board[r][c]==0?1:n/2+1;
	}
	private static boolean backtrack(Square s){
		if(s.r==n)
			return true;
		if(board[s.r][s.c]!=def)
			return backtrack(s.inc());
		for(int x=0;x<2;x++){
			board[s.r][s.c]=x;
			if(x==0){
				rowsO[s.r]--;
				colsO[s.c]--;
			}else{
				rowsX[s.r]--;
				colsX[s.c]--;
			}
			if(locallyValid(s)&&backtrack(s.inc()))
					return true;
			if(x==0){
				rowsO[s.r]++;
				colsO[s.c]++;
			}else{
				rowsX[s.r]++;
				colsX[s.c]++;
			}
		}
		board[s.r][s.c]=def;
		return false;
	}
	private static int[]dX=new int[]{1,0};
	private static int[]dY=new int[]{0,1};
	private static boolean locallyValid(Square s){
		if(rowsO[s.r]<0||rowsX[s.r]<0||colsO[s.c]<0||colsX[s.c]<0)
			return false;
		for(int i:dX)
			for(int j:dY)
				if(i+j==1)
					if(tictactoe(s,new Square(s.r+i,s.c+j),new Square(s.r+2*i,s.c+2*j))||tictactoe(s,new Square(s.r-i,s.c-j),new Square(s.r-2*i,s.c-2*j))||tictactoe(s,new Square(s.r+i,s.c+j),new Square(s.r-i,s.c-j)))
						return false;
		return true;
	}
	private static boolean tictactoe(Square a,Square b,Square c){
		return a.valid()&&b.valid()&&c.valid()&&board[a.r][a.c]==board[b.r][b.c]&&board[b.r][b.c]==board[c.r][c.c];
	}
	private static void display(){
		for(int[]r:board){
			for(int x:r)
				System.out.print((x+1)+" ");
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
