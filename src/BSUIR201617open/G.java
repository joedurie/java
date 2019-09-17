package BSUIR201617open;
import java.util.*;
public class G {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		double n=sc.nextDouble(),k=sc.nextDouble();
		double last=0,next=-1;
		for(int i=1;i<=n;i++){
			double y=Math.floor(last);
			next=(y/k)*last+(1-y/k)*(sum(k)-sum(y))/(k-y);
			if(Math.abs(last-next)<Math.pow(10,-21))
				break;
			last=next;
		}
		System.out.println(next);
		sc.close();
	}
	static double sum(double d){
		return d*(d+1)/2.0;
	}
}
