package maps2019;
import java.util.*;
public class L {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		HashSet<P>spies=new HashSet<P>();
		HashSet<P>houses=new HashSet<P>();
		for(int i=0;i<n;i++){
			char[]s=sc.nextLine().toCharArray();
			for(int j=0;j<n;j++)
				if(s[j]=='S')
					spies.add(new P(i,j));
				else if(s[j]=='H')
					houses.add(new P(i,j));
		}
		sc.close();
		int max=0;
		for(P s:spies){
			int temp=Integer.MAX_VALUE;
			for(P h:houses)
				temp=Math.min(temp,s.dist(h));
			max=Math.max(max,temp);
		}
		System.out.println(max);
	}
	static class P{
		int x;
		int y;
		public P(int x,int y){
			this.x=x;
			this.y=y;
		}
		public int dist(P other){
			return Math.abs(x-other.x)+Math.abs(y-other.y);
		}
	}
}
