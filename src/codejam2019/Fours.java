package codejam2019;
import java.util.*;
public class Fours {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		for(int w=1;w<=t;w++){
			char[]n=sc.nextLine().toCharArray();
			String a="",b="";
			for(int i=0;i<n.length;i++)
				if(n[i]=='4'){
					a+="3";
					b+="1";
				}else{
					a+=n[i]+"";
					b+="0";
				}
			b=b.substring(b.indexOf('1'));
			System.out.println("Case #"+w+": "+a+" "+b);
		}
		sc.close();
	}
}
