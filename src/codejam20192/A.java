package codejam20192;
import java.util.*;
public class A {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int cases=sc.nextInt();
		for(int caseNum=1;caseNum<=cases;caseNum++){
			int n=sc.nextInt();
			Pair[]arr=new Pair[n];
			for(int i=0;i<n;i++)
				arr[i]=new Pair(sc.nextInt(),sc.nextInt());
			HashSet<String>dels=new HashSet<String>();
			for(int i=1;i<n;i++)
				for(int j=0;j<i;j++){
					int dC=arr[i].c-arr[j].c,dJ=arr[i].j-arr[j].j;
					if(dC!=0&&dJ!=0&&dC>0!=dJ>0){
						dC=Math.abs(dC);
						dJ=Math.abs(dJ);
						int g=gcd(dC,dJ);
						dC/=g; dJ/=g;
						dels.add(dC+" "+dJ);
					}
				}
			System.out.println("Case #"+caseNum+": "+(dels.size()+1));
		}
		sc.close();
	}
	private static int gcd(int a,int b){
		return b==0?a:gcd(b,a%b);
	}
	private static class Pair{
		int c,j;
		public Pair(int f,int s){
			c=f;
			j=s;
		}
	}
}
