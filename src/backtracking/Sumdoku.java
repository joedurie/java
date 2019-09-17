package backtracking;
import java.util.*;
public class Sumdoku{
	private static int n=9,m=9,l=9,maxVal=9;
	private static int[][]board;
	private static char[][]left;
	private static char[][]up;
	private static HashMap<Integer,HashSet<Integer>>rows=new HashMap<Integer,HashSet<Integer>>();
	private static HashMap<Integer,HashSet<Integer>>cols=new HashMap<Integer,HashSet<Integer>>();
	private static HashMap<Integer,HashSet<Integer>>rects=new HashMap<Integer,HashSet<Integer>>();
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int t=0;t<p;t++){
			board=new int[n][m];
			left=new char[n][m];
			up=new char[n][m];
			System.out.println(sc.nextInt());
			initialize(sc);
			boolean b=backtrack(new Square(0,0));
			display();
		}
	}
	private static void initialize(Scanner sc){
		sc.nextLine();
		for(int r=0;r<n;r++)
			rows.put(r,allVals());
		for(int c=0;c<m;c++)
			cols.put(c,allVals());
		for(int w=0;w<l;w++)
			rects.put(w,allVals());
		for(int r=0;r<n;r++)
			for(int c=0;c<m;c++){
				up[r][c]='X';
				left[r][c]='X';
			}
		int row=0,row2=1;
		for(int i=0;i<15;i++){
			char[]s=sc.nextLine().toCharArray();
			if(s.length==6){
				int ind=0;
				for(int c=0;c<m;c++)
					if(c%3!=0)
						left[row][c]=s[ind++];
				row++;
			}else{
				for(int c=0;c<m;c++)
					up[row2][c]=s[c];
				row2++;
				if(row2%3==0)
					row2++;
			}
		}
	}
	private static boolean backtrack(Square s){
		if(s.r==n)
			return true;
		HashSet<Integer>vals=ok(s);
		for(int x:vals){
			board[s.r][s.c]=x;
			if(locallyValid(s,x)){
				rows.get(s.r).remove(x);
				cols.get(s.c).remove(x);
				rects.get(s.rect()).remove(x);
				if(backtrack(s.inc()))
					return true;
				rows.get(s.r).add(x);
				cols.get(s.c).add(x);
				rects.get(s.rect()).add(x);
			}
		}
		board[s.r][s.c]=0;
		return false;
	}
	private static boolean locallyValid(Square s,int x){
		return works(s,new Square(s.r-1,s.c),up[s.r][s.c])&&works(s,new Square(s.r,s.c-1),left[s.r][s.c]);
	}
	private static boolean works(Square s,Square t,char c){
		if(!s.valid()||!t.valid()||c=='X')
			return true;
		int sum=board[s.r][s.c]+board[t.r][t.c];
		if(c=='>')
			return sum>10;
		if(c=='<')
			return sum<10;
		return sum==10;
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
	private static HashSet<Integer>ok(Square s){
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
			return r/3+3*(c/3);//IMPLEMENT
		}
		private boolean valid(){
			return r>=0&&c>=0&&r<n&&c<m;
		}
		public String toString(){
			return "("+r+","+c+"): "+board[r][c];
		}
	}
}
