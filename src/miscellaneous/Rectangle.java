package miscellaneous;
import java.util.*;
public class Rectangle {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int q=0;q<t;q++){
			long gx=sc.nextLong(),gy=sc.nextLong(),gw=sc.nextLong(),gh=sc.nextLong();
			long dx=sc.nextLong()-gx,dy=sc.nextLong()-gy,dw=sc.nextLong(),dh=sc.nextLong();
			long k=sc.nextInt();
			long[]dCx=new long[]{dx,dx+dw};
			long[]dCy=new long[]{dy,dy+dh};
			long a=0;
			for(long x:dCx)
				for(long y:dCy){
					long mx=(x%gw+gw)%gw,my=(y%gh+gh)%gh;
					long gCx=x-mx,gCy=y-my;
					long thisK=Math.abs(gCx)/gw+Math.abs(gCy)/gh;
					System.out.println(gCx+" "+gCy+" "+thisK+"("+mx+" "+my+")");
					if(thisK<=k){
						long thisW=Math.min(dw,x==dx?gw-mx:mx);
						long thisH=Math.min(dh,y==dy?gh-my:my);
						System.out.println(thisW+" "+thisH+"\n");
						a=Math.max(a,thisW*thisH);
						if(thisK<=k-1&&dw/gw>=2)
							a=Math.max(a,gw*thisH);
						if(thisK<=k-1&&dh/gh>=2)
							a=Math.max(a,thisW*gh);
						if(thisK<=k-2&&dw/gw>=2&&dh/gh>=2)
							a=gw*gh;
					}
				}
			System.out.println(a);
		}
		sc.close();
	}
}
