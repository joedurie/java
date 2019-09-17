package maps2019;
import java.util.*;
public class J {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		HashSet<Integer>times=new HashSet<Integer>();
		for(int i=0;i<n;i++){
			int t=sc.nextInt();
			boolean b=false;
			for(int j=0;j<t;j++){
				int x=sc.nextInt();
				if(!b&&!times.contains(x)){
					times.add(x);
					b=true;
				}
			}
		}
		sc.close();
		System.out.println(times.size());
	}
}
