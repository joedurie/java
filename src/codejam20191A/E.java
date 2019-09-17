package codejam20191A;
import java.util.*;
public class E {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		HashSet<String>a=new HashSet<String>();
		HashSet<String>b=new HashSet<String>();
		int cA=0,cB=0;
		int[]arrA={2,3,5,7,11,13,17};
		int[]arrB={12,13,14,15,16,17,18};
		for(int i=1;i<1000000;i++){
			String sA="",sB="";
			for(int x:arrA)
				sA+=i%x+" ";
			for(int y:arrB)
				sB+=i%y+" ";
			if(a.contains(sA))
				cA++;
			else
				a.add(sA);
			if(b.contains(sB))
				cB++;
			else
				b.add(sB);
		}
		System.out.println(cA+" "+cB);
		sc.close();
	}
}
