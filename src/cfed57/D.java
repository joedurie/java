package cfed57;
import java.util.*;
public class D {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		char[]s=sc.nextLine().toCharArray();
		long[]a=new long[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextLong();
		sc.close();
		char[]hard=new char[]{'h','a','r','d'};
		long min=Long.MAX_VALUE;
		for(int i=0;i<hard.length;i++)
			for(int j=i+1;j<hard.length;j++){
				min=Math.min(min,costToFlip(hard[i],hard[j],s,a));
				System.out.println(min+" "+hard[i]+" "+hard[j]);
			}
		System.out.println(min);
	}
	public static long costToFlip(char h,char d,char[]s,long[]a){
		long[]pH=new long[s.length];
		for(int i=0;i<s.length;i++){
			pH[i]=i==0?0:pH[i-1];
			if(s[i]==h)
				pH[i]+=a[i];
		}
		long[]pD=new long[s.length];
		for(int i=s.length-1;i>=0;i--){
			pD[i]=i==s.length-1?0:pD[i+1];
			if(s[i]==d)
				pD[i]+=a[i];
		}
		long min=Long.MAX_VALUE;
		for(int i=0;i<s.length;i++){
			min=Math.min(min,pH[i]+pD[i]);
			System.out.println("M"+i+" "+pD[i]+" "+pH[i]+" "+min);
		}
		return min;
	}
}