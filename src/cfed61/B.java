package cfed61;
import java.util.*;
public class B {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long[]a=new long[n];
		long sum=0;
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			sum+=a[i];
		}
		Arrays.sort(a);
		long m=sc.nextInt();
		for(int i=0;i<m;i++)
			System.out.println(sum-a[n-sc.nextInt()]);
		sc.close();
	}
}
