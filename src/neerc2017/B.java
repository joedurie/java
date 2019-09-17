package neerc2017;
import java.util.*;
public class B {
	static int w,h;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt(),y=sc.nextInt(),z=sc.nextInt();
		w=sc.nextInt();
		h=sc.nextInt();
		int a=Math.max(Math.max(x,y),z),c=Math.min(Math.min(x,y),z),b=x+y+z-a-c;
		System.out.println(works(b+2*c,2*a+2*c)||works(a+2*c,2*b+2*c)||works(b+c,3*a+b+c)||works(a+c,3*b+a+c)||works(a+b,3*c+a+b)?"Yes":"No");
		sc.close();
	}
	private static boolean works(int p,int q){
		return Math.min(p,q)<=Math.min(w,h)&&Math.max(p,q)<=Math.max(w,h);
	}
}
