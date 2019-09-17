package icpcpractice2018;
import java.util.*;
public class ChanukahChallenge {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		for(int i=1;i<=p;i++){
			sc.nextInt();
			int n=sc.nextInt();
			System.out.println(i+" "+((n*(n+1))/2+n));
		}
		sc.close();
	}
}