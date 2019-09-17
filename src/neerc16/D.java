package neerc16;
import java.util.*;
public class D {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		double h1=sc.nextDouble(),t1=sc.nextDouble();
		double h2=sc.nextDouble(),t2=sc.nextDouble();
		double a=h2-h1;
		double b=-2*h2*t1+2*h1*t2;
		double c=h2*t1*t1-h1*t2*t2;
		double d1=((-1*b+Math.sqrt(b*b-4*a*c))/(2*a));
		double d2=((-1*b-Math.sqrt(b*b-4*a*c))/(2*a));
		if(d1<=t1&&d1<=t2)
			System.out.println(d1);
		else
			System.out.println(d2);
	}
}
