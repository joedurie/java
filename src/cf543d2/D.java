package cf543d2;
import java.util.*;
public class D {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt();
		int[]a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		sc.close();
		int ind=0,done=0,ans=0;
		TreeMap<Integer,Anus>q=new TreeMap<Integer,Anus>();
		for(int i=0;i<k;i++)
			if(ind<n)
				q.put(a[ind++],new Anus(0));
		while(!q.isEmpty()){
			int f=q.firstKey();
			while(!q.isEmpty()&&q.firstKey()==f){
				q.pollFirstEntry();
				done++;
				if(ind<n)
					q.put(f+a[ind++],new Anus(f));
			}
			if(!q.isEmpty()){
				int s=q.firstKey();
				for(int i:q.keySet()){
					if(q.get(i).b&&i-q.get(i).n>=p(done,n)){
						int test=q.get(i).n+p(done,n);
						if(test<=s){
							q.get(i).fuck();
							System.out.println(i-q.get(i).n);
							ans++;
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
	private static int p(double d,double n){
		return (int)Math.round(100*d/n);
	}
	private static class Anus{
		int n;
		boolean b;
		public Anus(int nn){
			n=nn;
			b=true;
		}
		public void fuck(){
			b=false;
		}
	}
}
