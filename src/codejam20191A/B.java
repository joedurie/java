package codejam20191A;
import java.util.*;
public class B {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt(),n=sc.nextInt(),m=sc.nextInt();
		for(int w=1;w<=t;w++){
			int[]results=new int[7];
			for(int i=0;i<7;i++){
				for(int j=0;j<18;j++)
					System.out.print((12+i)+(j<17?" ":""));
				System.out.println();
				System.out.flush();
				for(int j=0;j<18;j++)
					results[i]=(results[i]+sc.nextInt())%(i+12);
			}
			for(int i=1;i<=m;i++){
				boolean good=true;
				for(int j=0;j<7;j++)
					if(i%(j+12)!=results[j])
						good=false;
				if(good){
					System.out.println(i);
					System.out.flush();
					break;
				}
			}
			if(sc.nextInt()==-1)
				break;
		}
		sc.close();
	}
}
