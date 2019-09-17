package cf532d2;
import java.util.*;
public class F {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[]xor=new int[n];
		xor[0]=sc.nextInt();
		for(int i=1;i<n;i++)
			xor[i]=sc.nextInt()^xor[i-1];
		int q=sc.nextInt();
		for(int i=0;i<q;i++){
			int l=sc.nextInt()-1,r=sc.nextInt()-1;
			System.out.println(l==0?xor[r]:xor[r]^xor[l-1]);
		}
		sc.close();
	}
}
