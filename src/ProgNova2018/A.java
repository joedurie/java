package ProgNova2018;
import java.util.*;
public class A {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		sc.close();
		int k=Integer.parseInt(s.substring(s.indexOf(" ")+1));
		s=s.substring(0,s.indexOf(" "));
		boolean ordered=true;
		for(int i=0;i<s.length()-1;i++)
			if(s.charAt(i)>s.charAt(i+1))
				ordered=false;
		boolean possible=k<s.length()||ordered;
		for(int i=0;i<s.length();i++){
			if(i<k&&s.length()-i-1<k){
				int ct=0;
				int eCt=-1;
				for(int j=0;j<s.length();j++)
					if(s.charAt(j)<s.charAt(i))
						ct++;
					else if(s.charAt(j)==s.charAt(i))
						eCt++;
				if(Math.max(Math.abs(i-ct),Math.abs(i-ct-eCt))<k&&(i<ct||i>ct+eCt))
					possible=false;
			}
		}
		System.out.println(possible?"Yes":"No");
	}
}