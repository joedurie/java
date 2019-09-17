package miscellaneous;
import java.util.*;
public class RangeSumSegtree {
	static long[]a;
	static long[]segtree;
	static int n,q;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		a=new long[n];
		for(int i=n-1;i>=0;i--)
			a[i]=sc.nextInt();
		q=sc.nextInt();
		segtree=new long[5*(n+q)];
		makeNode(1,0,n+q-1);
		int i=n;
		for(int t=0;t<q;t++)
			if(sc.nextInt()==1)
				System.out.println(sum(1,0,n+q-1,i-sc.nextInt(),i-sc.nextInt()));
			else
				insert(1,0,n+q-1,i++,sc.nextInt());
		sc.close();
	}
	static void insert(int i,int l,int r,int ind,int x){
		if(ind>=l&&ind<=r){
			if(r>l){
				int m=(l+r)/2;
				insert(2*i,l,m,ind,x);
				insert(2*i+1,m+1,r,ind,x);
			}
			segtree[i]+=x;
		}
	}
	static long sum(int i,int l,int r,int qR,int qL){
		if(qR<l||qL>r)
			return 0;
		if(l>=qL&&r<=qR)
			return segtree[i];
		int m=(l+r)/2;
		return sum(2*i,l,m,qR,qL)+sum(2*i+1,m+1,r,qR,qL);
	}
	static long makeNode(int i,int l,int r){
		if(l==r)
			return l>=n?0:(segtree[i]=a[l]);
		int m=(l+r)/2;
		return segtree[i]=makeNode(2*i,l,m)+makeNode(2*i+1,m+1,r);
	}
}
