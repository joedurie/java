package cf538d2;
import java.util.*;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n=sc.nextLong(),b=sc.nextLong();
		sc.close();
		int x=2;
		long min=Long.MAX_VALUE;
		while(b>=x){
			int ct=0;
			while(b%x==0){
				b/=x;
				ct++;
			}
			if(ct>0){
				long temp=0,y=x;
				while(y<=n&&y>0){
					temp+=n/y;
					y*=x;
				}
				min=Math.min(temp/ct,min);
			}
			x+=x==2?1:2;
		}
		System.out.println(min);
	}
}
