package lanqiao2018;
import java.util.Scanner;
public class D {
	private static int[]lefts={1,0,3,2,5,4};
	private static int[]rights={5,3,4,1,2,0};
	private static long[]movesOfType=new long[6];
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long x=sc.nextLong()-1,y=sc.nextLong()-1;
		sc.close();
		int type=1;
		long ind=(long)Math.pow(2,n-1)-1;
		while((long)Math.pow(2,n)>=Long.MAX_VALUE){
			type=lefts[type];
			ind=(long)Math.pow(2,--n-1)-1;
			System.out.println(n);
		}
		fill(type,ind,ind,x,y);
		for(long i:movesOfType)
			System.out.println(i);
	}
	public static void fill(int moveType,long ind,long incr,long x,long y){
		if(incr>0&&ind-incr>=x&&ind+incr<=y){
			long[]moveCounts=new long[6];
			moveCounts[moveType]=1;
			completelyFill(moveCounts,incr);
		}else if(ind-incr<=y||ind+incr>=x){
			System.out.println(incr);
			if(ind>=x&&ind<=y)
				movesOfType[moveType]++;
			if(incr>0){
				fill(lefts[moveType],ind-(incr+1)/2,incr/2,x,y);
				fill(rights[moveType],ind+(incr+1)/2,incr/2,x,y);
			}
		}
	}
	public static void completelyFill(long[]moveCounts,long incr){
		for(int i=0;i<moveCounts.length;i++)
			movesOfType[i]+=moveCounts[i];
		if(incr>0){
			long[]tempCounts=new long[6];
			for(int i=0;i<moveCounts.length;i++){
				tempCounts[lefts[i]]+=moveCounts[i];
				tempCounts[rights[i]]+=moveCounts[i];
			}
			completelyFill(tempCounts,incr/2);
		}
	}
}