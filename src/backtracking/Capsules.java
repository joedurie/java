package backtracking;
import java.util.*;
public class Capsules{
	private static int n,m,l,def=0;//FILL IN VALUES
	private static int[][]board;
	private static int[][]rect;
	private static ArrayList<HashSet<Integer>>rects;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int t=0;t<p;t++){
			System.out.println(sc.nextInt());
			n=sc.nextInt();
			m=sc.nextInt();
			board=new int[n][m];
			rect=new int[n][m];
			rects=new ArrayList<HashSet<Integer>>();
			initialize(sc);
			boolean b=backtrack(new Square(0,0));
			display();
		}
	}
	private static void initialize(Scanner sc){
		sc.nextLine();
		for(int r=0;r<n;r++){
			String[]s=sc.nextLine().split(" ");
			for(int c=0;c<m;c++)
				if(s[c].equals("-"))
					board[r][c]=def;
				else
					board[r][c]=Integer.parseInt(s[c]);
		}
		l=sc.nextInt();
		for(int w=0;w<l;w++){
			int x=sc.nextInt();
			rects.add(allVals(x));
			String[]s=sc.nextLine().trim().split(" ");
			for(int i=0;i<x;i++){
				int r=s[i].charAt(1)-'1',c=s[i].charAt(3)-'1';
				rect[r][c]=w;
				if(board[r][c]!=0)
					rects.get(w).remove(board[r][c]);
			}
		}
	}
	private static boolean backtrack(Square s){
		if(s.r==n)
			return true;
		if(board[s.r][s.c]!=def)
			return backtrack(s.inc());
		HashSet<Integer>vals=new HashSet<Integer>();
		for(int i:rects.get(rect[s.r][s.c]))
			vals.add(i);
		for(int x:vals){
			board[s.r][s.c]=x;
			if(locallyValid(s)){
				rects.get(rect[s.r][s.c]).remove(x);
				if(backtrack(s.inc()))
					return true;
				rects.get(rect[s.r][s.c]).add(x);
			}
		}
		board[s.r][s.c]=def;
		return false;
	}
	private static boolean locallyValid(Square s){
		int[]dels={-1,0,1};
		for(int i:dels)
			for(int j:dels)
				if((i!=0||j!=0)&&new Square(s.r+i,s.c+j).valid()&&board[s.r+i][s.c+j]==board[s.r][s.c])
					return false;
		return true;
	}
	private static void display(){
		for(int[]r:board){
			String s="";
			for(int x:r)
				s+=x+" ";
			System.out.println(s.trim());
		}
	}
	private static HashSet<Integer>allVals(int n){
		HashSet<Integer>set=new HashSet<Integer>();
		for(int i=1;i<=n;i++)
			set.add(i);
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
		private boolean valid(){
			return r>=0&&c>=0&&r<n&&c<m;
		}
		public String toString(){
			return "("+r+","+c+")";
		}
	}
}
