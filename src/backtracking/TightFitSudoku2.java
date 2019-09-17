package backtracking;
import java.util.*;
public class TightFitSudoku2{
	private static int n=6,m=12,l=6,maxVal=9,def=0;//FILL IN VALUES
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
			cMasks=new int[m/2];
			sMasks=new int[l];
			System.out.println(sc.nextInt());//test case number
			initialize(sc);
			boolean b=backtrack(new Square(0,0));//need to handle b false?
			display();
		}
	}
	private static void initialize(Scanner sc){
		for(int r=0;r<n;r++)
			rMasks[r]=(1<<(maxVal+1))-1;
		for(int c=0;c<m/2;c++)
			cMasks[c]=(1<<(maxVal+1))-1;
		for(int w=0;w<l;w++)
			sMasks[w]=(1<<(maxVal+1))-1;
		sc.nextLine();
		for(int r=0;r<n;r++){
			String[]arr=sc.nextLine().replaceAll("-","0").split(" ");
			for(int c=0;c<6;c++){
				if(arr[c].length()==1){
					int a=arr[c].charAt(0)-'0';
					board[r][2*c]=a;
					board[r][2*c+1]=10;
					rMasks[r]^=1<<a;
					cMasks[c]^=1<<a;
					sMasks[rect(r,2*c)]^=1<<a;
				}else{
					int a=arr[c].charAt(0)-'0',b=arr[c].charAt(2)-'0';
					board[r][2*c]=a;
					board[r][2*c+1]=b;
					rMasks[r]^=1<<a;
					cMasks[c]^=1<<a;
					sMasks[rect(r,2*c)]^=1<<a;
					rMasks[r]^=1<<b;
					cMasks[c]^=1<<b;
					sMasks[rect(r,2*c+1)]^=1<<b;
				}
			}
		}
	}
	private static boolean backtrack(Square s){
		if(s.r==n)
			return true;
		if(board[s.r][s.c]!=def)
			return backtrack(s.inc());
		int mask=rMasks[s.r]&cMasks[s.c/2]&sMasks[rect(s.r,s.c)];
		for(int x=1;x<=maxVal;x++)
			if((mask&(1<<x))>0&&locallyValid(s,x)){
				board[s.r][s.c]=x;
				rMasks[s.r]^=1<<x;
				cMasks[s.c/2]^=1<<x;
				sMasks[rect(s.r,s.c)]^=1<<x;
				if(backtrack(s.inc()))
					return true;
				rMasks[s.r]|=1<<x;
				cMasks[s.c/2]|=1<<x;
				sMasks[rect(s.r,s.c)]|=1<<x;
			}
		board[s.r][s.c]=def;
		return false;
	}
	private static boolean locallyValid(Square s, int x){
		if(s.c%2==1)
			return x>board[s.r][s.c-1];
		return board[s.r][s.c+1]==0||board[s.r][s.c+1]>x;
	}
	private static int rect(int r,int c){
		return r/2+3*(c/6);
	}
	private static void display(){
		for(int[]r:board){
			for(int c=0;c<6;c++)
				System.out.print(r[2*c]+(r[2*c+1]==10?" ":"/"+r[2*c+1]+" "));
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
