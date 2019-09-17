package neerc16;
import java.util.*;
public class C {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[]args){
		System.out.println("A "+bSearch(0,1000000000,"%d 0\n")+" "+bSearch(0,1000000000,"0 %d\n"));
		System.out.flush();
	}
	public static int bSearch(int min,int max,String f){
		if(min==max)
			return min;
		ask(min,f);
		int mid=(min+max)/2;
		if(ask(max,f)==1)
			return bSearch(mid+1,max,f);
		return bSearch(min,mid,f);
	}
	public static int ask(int i,String f){
		System.out.printf(f,i);
		System.out.flush();
		return sc.nextInt();
	}
}