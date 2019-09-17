package codejam2019;
import java.util.*;
public class DatBae {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int w=1;w<=t;w++){
			int n=sc.nextInt(),b=sc.nextInt(),f=sc.nextInt(),p=16;
			int[]missing=new int[(int)Math.ceil(n/16.0)];
			sc.nextLine();
			while(p>0){
				for(int i=0;i<n;i++)
					System.out.print((i/p)%2==0?0:1);
				System.out.println();
				System.out.flush();
				String resp=sc.nextLine();
				if(p==16){
					int run=0,ind=0;
					char last='0';
					for(int i=0;i<resp.length();i++){
						if(resp.charAt(i)==last)
							run++;
						else{
							missing[ind++]=16-run;
							run=1;
						}
						last=resp.charAt(i);
					}
					missing[ind++]=16-run;
					if(ind<missing.length)
						missing[ind]=16;
				}else{
					int[]newMissing=new int[2*missing.length];
					int lastEnd=0;
					for(int i=0;i<missing.length;i++){
						int newEnd=lastEnd+2*p-missing[i];
						String st=resp.substring(lastEnd,newEnd);
						lastEnd=newEnd;
						newMissing[2*i]=(st.indexOf('1')==-1?p-st.length():p-st.indexOf('1'));
						newMissing[2*i+1]=missing[i]-newMissing[2*i];
					}
					missing=copy(newMissing);
				}
				p/=2;
			}
			for(int i=0;i<n;i++)
				if(missing[i]==1)
					System.out.print(i+" ");
			System.out.println();
			System.out.flush();
			int r=sc.nextInt();
			if(r!=1)
				break;
		}
		sc.close();
	}
	private static int[] copy(int[]arr){
		int[]res=new int[arr.length];
		for(int i=0;i<arr.length;i++)
			res[i]=arr[i];
		return res;
	}
}
