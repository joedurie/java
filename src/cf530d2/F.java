package cf530d2;
import java.util.*;
public class F {
	static long[]sec;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sec=new long[n];
		long T=sc.nextLong();
		long[]x=new long[n];
		for(int i=0;i<n;i++)
			x[i]=sc.nextInt();
		long[]t=new long[n];
		for(int i=0;i<n;i++)
			t[i]=sc.nextInt();
		int[]par=new int[n];
		par[0]=-1;
		HashMap<Integer,HashSet<Integer>>children=new HashMap<Integer,HashSet<Integer>>();
		long[]l=new long[n];
		l[0]=T;
		children.put(0,new HashSet<Integer>());
		for(int i=1;i<n;i++){
			children.put(i,new HashSet<Integer>());
			par[i]=sc.nextInt()-1;
			children.get(par[i]).add(i);
			l[i]=l[par[i]]-2*sc.nextInt();
		}
		sc.close();
		boolean[]used=new boolean[n];
		TreeMap<Long,Long>cookies=new TreeMap<Long,Long>();
		int ind=0;
		long[]cPer=new long[n];
		for(int no=0;no<n;no++){
			used[ind]=true;
			if(cookies.containsKey(t[ind]))
				cookies.put(t[ind],cookies.get(t[ind])+x[ind]);
			else
				cookies.put(t[ind],x[ind]);
			Iterator<Long>it=cookies.keySet().iterator();
			long lI=l[ind];
			while(lI>0&&it.hasNext()){
				long tI=it.next(),xI=cookies.get(tI);
				if(lI>tI*xI){
					lI-=tI*xI;
					cPer[ind]+=x[ind];
				}else{
					cPer[ind]+=lI/tI;
					lI=-1;
				}
			}
			boolean child=false;
			System.out.println(ind);
			do{
				if(children.containsKey(ind)){
				for(int c:children.get(ind))
					if(!used[c]){
						ind=c;
						child=true;
					}
				}
				if(!child&&ind>0){
					cookies.put(t[ind],cookies.get(t[ind])-x[ind]);
					if(cookies.get(t[ind])<=0)
						cookies.remove(t[ind]);
					ind=par[ind];
				}
			}while(!child&&ind!=0&&ind!=n-1);
		}
		for(long i:cPer)
			System.out.println(i+"J");
		getSec(par,cPer,children,0);
		long max=0;
		for(long i:sec)
			if(i>max)
				max=i;
		System.out.println(max);
	}
	private static void getSec(int[]par,long[]cPer,HashMap<Integer,HashSet<Integer>>children,int ind){
		if(children.get(ind).isEmpty()||children.get(ind).size()==1)
			sec[ind]=cPer[ind];
		long max=0,sMax=0;
		for(int i:children.get(ind)){
			getSec(par,cPer,children,i);
			if(sec[i]>max){
				sMax=max;
				max=sec[i];
			}else if(sec[i]>sMax)
				sMax=sec[i];
		}
		sec[ind]=Math.max(sMax,cPer[ind]);
	}
}
