package cfed60;
import java.util.*;
public class C {
	private static int x1,x2,y1,y2;
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		x1=sc.nextInt();
		y1=sc.nextInt();
		x2=sc.nextInt();
		y2=sc.nextInt();
		int n=sc.nextInt();
		sc.nextLine();
		char[]s=sc.nextLine().toCharArray();
		sc.close();
		int dx=0,dy=0;
		for(char c:s)
			if(c=='U')
				dy++;
			else if(c=='D')
				dy--;
			else if(c=='L')
				dx--;
			else
				dx++;
		if(dx==0&&dy==0)
			System.out.println(dist());
		else{
			int ans=0;
			int lastD=Integer.MAX_VALUE;
			boolean done=false;
			boolean impossible=false;
			while(!done&&dist()<lastD){
				ans+=n;
				if(dist()<=ans)
					done=true;
				if(dist()>lastD)
					impossible=true;
				lastD=dist();
				x1+=dx;
				y1+=dy;
			}
			x1-=2*dx;
			y1-=2*dy;
			ans-=2*n;
			while(ans<0){
				ans+=n;
				x1+=dx;
				y1+=dy;
			}
			int ind=-1;
			if(!impossible){
				for(int i=0;i<2*n;i++){
					if(dist()<=i+ans&&ind==-1)
						ind=i+ans;
					char c=s[i%n];
					if(c=='U')
						y1++;
					else if(c=='D')
						y1--;
					else if(c=='L')
						x1--;
					else
						x1++;
				}
				if(dist()<=2*n+ans&&ind==-1)
					ind=2*n+ans;
			}
			System.out.println(ind);
		}
	}
	public static int dist(){
		return Math.abs(x2-x1)+Math.abs(y2-y1);
	}
}