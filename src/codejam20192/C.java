package codejam20192;
import java.util.*;
public class C {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int cases=sc.nextInt();
		for(int caseNum=1;caseNum<=cases;caseNum++){
			int n=sc.nextInt();
			Pair[]arr=new Pair[n];
			for(int i=0;i<n;i++)
				arr[i]=new Pair(sc.nextInt(),sc.nextInt());
			double lBound=0,rBound=Double.MAX_VALUE;
			boolean impossible=false;
			for(int i=1;i<n;i++)
				for(int j=0;j<i;j++){
					int dC=arr[i].c-arr[j].c,dJ=arr[i].j-arr[j].j;
					if(dC<=0&&dJ<=0)
						impossible=true;
					if(dC!=0&&dJ!=0&&dC>0!=dJ>0){
						double x=Math.abs(dJ)/(double)Math.abs(dC);
						if(dC<0)
							rBound=Math.min(rBound,x);
						else
							lBound=Math.max(lBound,x);
					}
				}
			//System.out.println(lBound+" "+rBound);
			if(lBound>=rBound||impossible)
				System.out.println("Case #"+caseNum+": IMPOSSIBLE");
			else if(lBound==0){
				int c=1,j=(int)Math.floor(1+1/rBound);
				System.out.println("Case #"+caseNum+": "+c+" "+j);
			}else{
				int c=1,j;
				while(true){
					j=(int)Math.floor(c/lBound-1);
					if((c/(double)j)<rBound&&j>0)
						break;
					c++;
				}
				System.out.println("Case #"+caseNum+": "+c+" "+j);
			}
		}
		sc.close();
	}
	private static class Pair{
		int c,j;
		public Pair(int f,int s){
			c=f;
			j=s;
		}
	}
}
