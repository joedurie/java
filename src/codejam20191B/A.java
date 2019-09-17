package codejam20191B;
import java.util.*;
public class A {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int cs=1;cs<=t;cs++){
			int p=sc.nextInt(),q=sc.nextInt();
			int[]pSumY=new int[q+1];
			int[]sSumY=new int[q+1];
			int[]pSumX=new int[q+1];
			int[]sSumX=new int[q+1];
			for(int i=0;i<p;i++){
				int x=sc.nextInt(),y=sc.nextInt();
				char c=sc.nextLine().trim().charAt(0);
				switch(c){
					case 'N':
						pSumY[y+1]++;
						break;
					case 'S':
						sSumY[y-1]++;
						break;
					case 'E':
						pSumX[x+1]++;
						break;
					default:
						sSumX[x-1]++;
						break;
				}
			}
			for(int i=1;i<=q;i++){
				pSumY[i]+=pSumY[i-1];
				pSumX[i]+=pSumX[i-1];
			}
			for(int i=q-1;i>=0;i--){
				sSumY[i]+=sSumY[i+1];
				sSumX[i]+=sSumX[i+1];
			}
			int maxY=-1,maxValY=-1;
			for(int y=0;y<=q;y++)
				if(pSumY[y]+sSumY[y]>maxValY){
					maxY=y;
					maxValY=pSumY[y]+sSumY[y];
				}
			int maxX=-1,maxValX=-1;
			for(int x=0;x<=q;x++)
				if(pSumX[x]+sSumX[x]>maxValX){
					maxX=x;
					maxValX=pSumX[x]+sSumX[x];
				}
			System.out.println("Case #"+cs+": "+maxX+" "+maxY);
		}
		sc.close();
	}
}
