package codejam20191B;
import java.util.*;
public class D {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		long[]nums={sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};
		long[]coeff1={50,25,16,12,10,8};
		long[]coeff2={0,0,50,37,30,25};
		long res1=0;
		for(int i=0;i<6;i++)
			res1+=nums[i]*Math.pow(2,coeff1[i]);
		System.out.println(res1);
		long res2=0;
		for(int i=2;i<6;i++)
			res2+=nums[i]*Math.pow(2,coeff2[i]);
		System.out.println(res2);
		sc.close();
	}
}
