package miscellaneous;
import java.util.*;
public class NumberGame {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int q=0;q<t;q++) {
			int n=sc.nextInt();
			int[]a=new int[n];
			int iOne=-1;
			for(int i=0;i<n;i++) {
				a[i]=sc.nextInt();
				if(a[i]==1)
					iOne=i;
			}
			int ind=iOne-2;
			while(ind>=0&&a[ind]<a[ind+1])
				ind--;
			int ctL=iOne-2-ind;
			ind=iOne+2;
			while(ind<n&&a[ind]<a[ind-1])
				ind++;
			int ctR=ind-(iOne+2);
			if(iOne==1)
				ctL=2;
			if(iOne==n-2)
				ctR=2;
			if(iOne==0)
				ctL=ctR;
			if(iOne==n-1)
				ctR=ctL;
			if(ctL==0||ctR==0)
				System.out.println(n%2==1?"Alice":"Bob");
			else if(ctR%2!=ctL%2)
				System.out.println("Alice");
			else
				System.out.println((n-ctL)%2==1?"Alice":"Bob");
		}
		sc.close();
	}
}
