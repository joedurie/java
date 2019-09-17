package cfed58;
import java.util.*;
public class E {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),min=0,max=0;
		sc.nextLine();
		for(int i=0;i<n;i++){
			String s=sc.nextLine();
			char c=s.charAt(0);
			s=s.substring(2);
			int a=Integer.parseInt(s.substring(0,s.indexOf(' ')));
			int b=Integer.parseInt(s.substring(s.indexOf(' ')+1));
			if(c=='+'){
				min=Math.max(Math.min(a, b), min);
				max=Math.max(Math.max(a, b), max);
			}else
				System.out.println(min<=Math.min(a, b)&&max<=Math.max(a, b)?"YES":"NO");
		}
		sc.close();
	}
}