package backtracking;
import java.util.*;
public class MMKnightTour{
	private static int n=8,m=8,def=0,inputDef=-1;//FILL IN VALUES
	private static int[][]board;
	private static HashMap<Integer,int[]>set;
	private static ArrayList<Integer>rows;
	private static ArrayList<Integer>cols;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int t=0;t<p;t++){
			board=new int[n][m];
			rows=new ArrayList<Integer>();
			cols=new ArrayList<Integer>();
			set=new HashMap<Integer,int[]>();
			System.out.println(sc.nextInt());//test case number
			initialize(sc);
			boolean b=false;
			int r=0,c=0;
			while(!b){
				b=backtrack(1,r,c);
				c++;
				if(c==m){
					c=0;
					r++;
				}
			}
			display();
		}
	}
	private static void initialize(Scanner sc){
		for(int r=0;r<n;r++)
			rows.add(260);
		for(int c=0;c<m;c++)
			cols.add(260);
		sc.nextLine();
		for(int r=0;r<n;r++)
			for(int c=0;c<m;c++){
				board[r][c]=sc.nextInt();
				if(board[r][c]==inputDef)
					board[r][c]=def;
				else
					set.put(board[r][c],new int[]{r,c});
				rows.set(r,rows.get(r)-board[r][c]);
				cols.set(c,cols.get(c)-board[r][c]);
			}
	}
	private static int[]dx={-2,-2,-1,-1,1,1,2,2};
	private static int[]dy={-1,1,-2,2,-2,2,-1,1};
	private static boolean backtrack(int num,int r,int c){
		if(num==65)
			return true;
		if(r<0||r>=n||c<0||c>=m||!locallyValid(r,c,num))
			return false;
		if(!set.containsKey(num)){
			board[r][c]=num;
			rows.set(r,rows.get(r)-num);
			cols.set(c,cols.get(c)-num);
		}
		for(int i=0;i<dx.length;i++)
			if(backtrack(num+1,r+dx[i],c+dy[i]))
				return true;
		if(!set.containsKey(num)){
			board[r][c]=def;
			rows.set(r,rows.get(r)+num);
			cols.set(c,cols.get(c)+num);
		}
		return false;
	}
	private static boolean locallyValid(int r,int c,int num){
		if(set.containsKey(num))
			return r==set.get(num)[0]&&c==set.get(num)[1];
		if(board[r][c]!=def)
			return false;
		if(rows.get(r)<num||cols.get(c)<num)
			return false;
		if(!set.containsKey(num+1))
			return true;
		int dr=Math.abs(set.get(num+1)[0]-r),dc=Math.abs(set.get(num+1)[1]-c);
		return Math.max(dr,dc)==2&&Math.min(dr, dc)==1;
	}
	private static void display(){
		for(int[]r:board){
			for(int x:r)
				System.out.print(x+" ");
			System.out.println();
		}
	}
}
