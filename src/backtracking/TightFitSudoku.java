package backtracking;
import java.util.*;
public class TightFitSudoku{
	private static int n=6,m=6,l=6,maxVal=9;
	private static Value[][]board;
	private static HashMap<Integer,HashSet<Integer>>rows=new HashMap<Integer,HashSet<Integer>>();
	private static HashMap<Integer,HashSet<Integer>>cols=new HashMap<Integer,HashSet<Integer>>();
	private static HashMap<Integer,HashSet<Integer>>rects=new HashMap<Integer,HashSet<Integer>>();
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int t=0;t<p;t++){
			board=new Value[n][m];
			System.out.println(sc.nextInt());
			initialize(sc);
			boolean b=backtrack(new Square(0,0),0);
			display();
		}
	}
	private static void initialize(Scanner sc){
		for(int r=0;r<n;r++)
			rows.put(r,allVals());
		for(int c=0;c<m;c++)
			cols.put(c,allVals());
		for(int w=0;w<l;w++)
			rects.put(w,allVals());
		sc.nextLine();
		for(int r=0;r<n;r++){
			String[]line=sc.nextLine().split(" ");
			for(int c=0;c<m;c++){
				board[r][c]=new Value(line[c]);
				for(int i:board[r][c].vals()){
					rows.get(r).remove(i);
					cols.get(c).remove(i);
					rects.get(r/2+3*(c/3)).remove(i);
				}
			}
		}
	}
	private static boolean backtrack(Square s,int i){
		if(s.r==n)
			return true;
		HashSet<Integer>set=ok(s);
		Value val=board[s.r][s.c];
		if(i==1&&!val.split)
			return backtrack(s.inc(),0);
		if(val.set[i])
			return backtrack(i==0?s:s.inc(),1-i);
		for(int x:set)
			if((i==0||x>val.v[0])&&(i==1||!val.set[1]||val.v[1]>x)){
				val.v[i]=x;
				rows.get(s.r).remove(x);
				cols.get(s.c).remove(x);
				rects.get(s.rect()).remove(x);
				if(i==0&&backtrack(s,1))
					return true;
				else if(i==1&&backtrack(s.inc(),0))
					return true;
				rows.get(s.r).add(x);
				cols.get(s.c).add(x);
				rects.get(s.rect()).add(x);
			}
		val.v[i]=0;
		return false;
	}
	private static void display(){
		for(Value[]r:board){
			for(Value v:r)
				System.out.print(v);
			System.out.println();
		}
	}
	private static HashSet<Integer>allVals(){
		HashSet<Integer>set=new HashSet<Integer>();
		for(int i=1;i<=maxVal;i++)
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
	private static int value(char c){
		if(c=='-')
			return 0;
		return c-'0';
	}
	private static class Value{
		int[]v=new int[2];
		boolean[]set=new boolean[2];
		boolean split;
		public Value(String s){
			if(s.length()==1){
				split=false;
				v[0]=value(s.charAt(0));
				set[0]=v[0]!=0;
				set[1]=false;
			}else{
				split=true;
				v[0]=value(s.charAt(0));
				v[1]=value(s.charAt(2));
				set[0]=v[0]!=0;
				set[1]=v[1]!=0;
			}
		}
		private HashSet<Integer>vals(){
			HashSet<Integer>s=new HashSet<Integer>();
			for(int i:v)
				if(i!=0)
					s.add(i);
			return s;
		}
		public String toString(){
			if(split)
				return v[0]+"/"+v[1]+" ";
			return v[0]+" ";
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
		private int rect(){
			return r/2+3*(c/3);
		}
		private boolean valid(){
			return r>=0&&c>=0&&r<n&&c<m;
		}
		public String toString(){
			return "("+r+","+c+"): "+board[r][c];
		}
	}
}
