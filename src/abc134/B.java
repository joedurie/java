package abc134;
import java.util.*;

public class B {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		double n=sc.nextDouble(),k=sc.nextDouble();
		System.out.println((int)Math.ceil(n/(2*k+1)));
	}
}
