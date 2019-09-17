package neerc16;
import java.util.*;
public class I {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[]a=new int[1828];
		for(int i=0;i<n;i++){
			a[sc.nextInt()]++;
			a[sc.nextInt()+1]--;
		}
		for(int i=1;i<1828;i++)
			a[i]+=a[i-1];
		int[]ct=new int[1828];
		for(int i=1;i<1828;i++)
			ct[i]=ct[i-1]+(a[i]>0?1:0);
		boolean ok=true;
		for(int i=180;i<1828;i++)
			if(ct[i]-ct[i-180]>90)
				ok=false;
		System.out.println(ok?"Yes":"No");
	}
}
