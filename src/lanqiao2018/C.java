package lanqiao2018;
import java.util.Scanner;
public class C {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String gene=sc.nextLine();
		sc.close();
		int sInd=0, gInd=0;
		while(sInd<s.length()&&gInd<gene.length()){
			if(gene.charAt(gInd)==s.charAt(sInd))
				sInd++;
			gInd++;
		}
		System.out.println(sInd==s.length()?gInd:-1);
	}
}
