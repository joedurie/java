package cf538d2;
import java.util.*;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
		Long[]a=new Long[n];
		for(int i=0;i<n;i++)
			a[i]=100000L*(sc.nextLong()+1000000000L)+i;
		sc.close();
		Arrays.sort(a);
		Integer[]inds=new Integer[k*m];
		long sum=0;
		for(int i=n-1;i>n-1-k*m;i--){
			inds[n-1-i]=(int)(a[i]%100000L);
			sum+=a[i]/100000L - 1000000000L;
		}
		Arrays.sort(inds);
		int ind=-1;
		System.out.println(sum);
		for(int i=1;i<=k-1;i++)
			System.out.print((inds[ind+=m]+1)+" ");
	}
}
