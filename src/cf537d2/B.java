package cf537d2;
import java.util.*;
public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(),k=sc.nextInt(),m=sc.nextInt();
		Integer[]a=new Integer[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		sc.close();
		Arrays.sort(a);
		int ind=0;
		while(a[ind]<a[n-1]&&m>0){
			ind++;
			m--;
		}
		long sum=0;
		for(int i=ind;i<n;i++)
			sum+=a[i];
		sum+=Math.min(m,k*(n-ind));
		System.out.println(sum/(double)(n-ind));
	}
}
