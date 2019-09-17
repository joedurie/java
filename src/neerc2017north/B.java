package neerc2017north;
import java.util.*;
import java.io.*;
public class B {
	public static void main(String[]args) throws IOException{
		//Scanner sc=new Scanner(new File("auxiliary.in"));
		//FileWriter fw=new FileWriter("auxiliary.out");
		String s=sc.nextLine();
		String vars="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0;i<52;i++)
			if(s.indexOf(ch)
		int n=sc.nextInt(),ans=0;
		if(n%3==2)
			ans=1;
		else if(n%3==1){
			ans=4;
			n-=4;
		}
		ans+=7*(n/3);
		fw.write(ans+"\n");
		sc.close();
		fw.close();
	}
}
