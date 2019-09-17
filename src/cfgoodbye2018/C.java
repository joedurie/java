package cfgoodbye2018;
import java.io.*;
import java.util.*;
public class C {
	public static void main(String[]args){
		PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out));
		Scanner sc=new Scanner(System.in);
		long n=sc.nextInt();
		sc.close();
		out.print("1 ");
		for(long i=n/2;i>=1;i--)
			if(n%i==0)
				out.print((long)(1+(n+2)*(n-i)/(2.0*i))+" ");
		out.close();
	}
}