package neerc16;
import java.util.*;
public class K {
	public static void main(String[]args){
		for(int u=9;u<30;u++){
			long n=(1<<u)*((1<<(u-1))-1);
			long m=0;
			for(long i=0;i<1<<(u+1);i++)
				m+=i^(i%2==0?i:((1<<(u-1))-i/2));
			System.out.println(n+" "+m);
		}
	}
}
