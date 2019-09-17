package abc125;
import java.util.*;

public class B {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[]v=new int[n];
		for(int i=0;i<n;i++)
			v[i]=sc.nextInt();
		long ans=0;
		for(int i=0;i<n;i++)
			ans+=Math.max(0,v[i]-sc.nextInt());
		System.out.println(ans);
		sc.close();
	}
}
