package neerc2017north;
import java.util.*;
import java.io.*;
public class I {
	public static void main(String[]args) throws IOException{
		Scanner sc=new Scanner(new File("intel.in"));
		FileWriter fw=new FileWriter("intel.out");
		//Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[]rows=new int[2000005];
		int[]cols=new int[2000005];
		int lR=sc.nextInt(),lC=sc.nextInt();
		int oR=lR,oC=lC;
		for(int i=1;i<=n;i++){
			int tR=oR,tC=oC;
			if(i<n){
				tR=sc.nextInt();
				tC=sc.nextInt();
			}
			if(tR==lR){
				int max=Math.max(lC,tC),min=Math.min(lC,tC);
				cols[max+1000000]--;
				cols[min+1000000]++;
			}else{
				int max=Math.max(lR,tR),min=Math.min(lR,tR);
				rows[max+1000000]--;
				rows[min+1000000]++;
			}
			lR=tR;
			lC=tC;
		}
		for(int i=1;i<rows.length;i++)
			rows[i]+=rows[i-1];
		for(int i=1;i<cols.length;i++)
			cols[i]+=cols[i-1];
		long ans=0;
		for(int i:rows)
			if(i>2)
				ans+=i-2;
		for(int i:cols)
			if(i>2)
				ans+=i-2;
		fw.write(ans+"\n");
		sc.close();
		fw.close();
	}
}
