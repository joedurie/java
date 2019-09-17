package codejam20192;
import java.util.*;
public class B {
	static int[]arr={1,2,3,4,5,100};
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int cases=sc.nextInt();
		for(int caseNum=1;caseNum<=cases;caseNum++){
			int j=0;
			for(int i=0;i<90;i++){
				j=sc.nextInt();
				System.out.println(arr[i%6]+" "+(i/6+1));
				System.out.flush();
			}
			int min=10000;
			TreeSet<Integer>mins=new TreeSet<Integer>();
			for(int i=0;i<5;i++){
				j=sc.nextInt();
				System.out.println("0 "+(16+i));
				System.out.flush();
				int n=sc.nextInt();
				for(int k=0;k<n;k++)
					sc.nextInt();
				if(n<min){
					min=n;
					mins=new TreeSet<Integer>();
					mins.add(16+i);
				}else if(n==min)
					mins.add(16+i);
			}
			int guess=mins.pollLast();
			for(int i:mins){
				j=sc.nextInt();
				System.out.println("100 "+i);
				System.out.flush();
			}
			while(j<99){
				j=sc.nextInt();
				System.out.println("100 4");
				System.out.flush();
			}
			j=sc.nextInt();
			System.out.println("100 "+guess);
		}
	}
}
