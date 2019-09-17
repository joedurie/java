package cfglobal1;
import java.util.*;
public class D {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		int[]num=new int[m];
		for(int i=0;i<n;i++)
			num[sc.nextInt()-1]++;
		sc.close();
		int sets=0;
		for(int i=2;i<num.length;i++){
			int min=Math.min(num[i],Math.min(num[i-1],num[i-2]));
			sets+=min;
			num[i]-=min;
			num[i-1]-=min;
			num[i-2]-=min;
		}
		for(int i:num)
			sets+=i/3;
		System.out.println(sets);
	}
}
