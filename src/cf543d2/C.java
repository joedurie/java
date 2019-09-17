package cf543d2;
import java.util.*;
public class C {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt();
		int[]a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		sc.close();
		int[]in=new int[n];
		int[]out=new int[n];
		TreeMap<Integer,Integer>kSet=new TreeMap<Integer,Integer>();
		int ind=0;
		for(int i=0;i<k;i++)
			if(ind<n){
				kSet.put(a[ind],ind);
				in[ind++]=0;
			}
		int pct=0,done=0;
		while(!kSet.isEmpty()){
			int f=kSet.firstKey();
			System.out.println(f);
			HashSet<Integer>temp=new HashSet<Integer>();
			while(!kSet.isEmpty()&&kSet.firstKey()==f){
				int x=kSet.pollFirstEntry().getValue();
				temp.add(x);
				done++;
			}
			pct=p(done,n);
			for(int i:temp){
				out[i]=pct;
				if(!kSet.isEmpty()&&ind<n){
					kSet.put(f+a[ind],ind);
					in[ind++]=pct;
				}
			}
		}
		for(int i=0;i<n;i++)
			System.out.println(in[i]+" -> "+out[i]);
		int ans=0;
		for(int i=0;i<n;i++){
			boolean b=false;
			for(int d=1;d<n;d++)
				if(p(d,n)>=in[i]&&p(d,n)<out[i])
					b=true;
			if(b)
				ans++;
		}
		System.out.println(ans);
	}
	private static int p(double d,double n){
		return (int)Math.round(100*d/n);
	}
}
