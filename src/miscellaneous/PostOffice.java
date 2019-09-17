package miscellaneous;
import java.util.*;
public class PostOffice {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int k=sc.nextInt();
		int[]houses=new int[n];
		for(int i=0;i<n;i++)
			houses[i]=sc.nextInt();
		sc.close();
		int[][]cost=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=i+2;j<n;j++){
				int c=0;
				for(int l=i+1;l<j;l++)
					c+=Math.min(houses[l]-houses[i],houses[j]-houses[l]);
				cost[i][j]=c;
			}
		int[]lastCost=new int[n];
		for(int i=0;i<n;i++)
			for(int j=0;j<i;j++)
				lastCost[i]+=houses[i]-houses[j];
		for(int i=1;i<k;i++){
			int[]thisCost=new int[n];
			for(int j=i;j<n;j++){
				int min=Integer.MAX_VALUE;
				for(int l=i-1;l<j;l++)
					if(lastCost[l]+cost[l][j]<min)
						min=lastCost[l]+cost[l][j];
				thisCost[j]=min;
			}
			lastCost=thisCost;
		}
		for(int i=0;i<n-1;i++)
			for(int j=i+1;j<n;j++)
				lastCost[i]+=houses[j]-houses[i];
		int min=lastCost[n-1];
		for(int i=k-1;i<n-1;i++)
			if(lastCost[i]<min)
				min=lastCost[i];
		System.out.println(min);
	}
}