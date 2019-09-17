package icpcpractice2018;
import java.util.*;
public class SumSquaredDigits {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int i=1;i<=p;i++){
			sc.nextInt();
			int b=sc.nextInt(),n=sc.nextInt();
			long sum=0;
			while(n>0){
				sum+=(n%b)*(n%b);
				n/=b;
			}
			System.out.println(i+" "+sum);
		}
		sc.close();
	}
}