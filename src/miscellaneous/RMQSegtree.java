package miscellaneous;
import java.util.*;
public class RMQSegtree {
	static int n;
	static int[]a;
	static int[]segtree;
	static int createNode(int i,int l,int r){
		if(l==r)
			return segtree[i]=a[l];
		int m=(l+r)/2;
		return segtree[i]=Math.min(createNode(2*i,l,m),createNode(2*i+1,m+1,r));
	}
	static int rmq(int i,int l,int r,int qL,int qR){
		if(qR<l||qL>r)
			return Integer.MAX_VALUE;
		if(l>=qL&&r<=qR)
			return segtree[i];
		int m=(l+r)/2;
		return Math.min(rmq(2*i,l,m,qL,qR),rmq(2*i+1,m+1,r,qL,qR));
	}
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		segtree=new int[5*n];
		segtree[1]=createNode(1,0,n-1);
		int q=sc.nextInt();
		for(int i=0;i<q;i++)
			System.out.println(rmq(1,0,n-1,sc.nextInt(),sc.nextInt()));
		sc.close();
	}
}
