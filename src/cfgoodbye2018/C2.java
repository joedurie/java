package cfgoodbye2018;
import java.io.*;
import java.util.*;
public class C2 {
	public static void main(String[]args){
		PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out));
		Scanner sc=new Scanner(System.in);
		long n=sc.nextInt();
		sc.close();
		LinkedList<Long>q=new LinkedList<Long>();
		Stack<Long>s=new Stack<Long>();
		for(long i=(int)Math.sqrt(n);i>=1;i--)
			if(n%i==0){
				q.addLast(i);
				if(n/i>i)
					s.push(n/i);
			}
		while(!s.isEmpty()){
			long i=s.pop();
			out.print((long)(1+(n+2)*(n-i)/(2.0*i))+" ");
		}
		for(long i:q)
			out.print((long)(1+(n+2)*(n-i)/(2.0*i))+" ");
		out.close();
	}
}