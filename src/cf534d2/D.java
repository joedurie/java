package cf534d2;
import java.util.*;
public class D {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		while(s.equals("start")){
				int upper=1000000001,lower=2;
				String r1="",r2="";
				boolean notX=false;
				int lastMid=-1;
				while(upper!=lower&&(upper+lower)/2!=lastMid){
					int mid=(upper+lower)/2;
					System.out.println("? "+mid+" "+(mid+1));
					System.out.flush();
					r1=sc.nextLine();
					System.out.println("? "+(mid+1)+" "+mid);
					System.out.flush();
					r2=sc.nextLine();
					lastMid=mid;
					if(r1.equals(r2))
						lower=Math.min(upper,mid+2);
					else
						upper=mid+1;
					if(!r1.equals("x")||!r2.equals("x"))
						notX=true;
					if(r1.equals("e")||r2.equals("e")){
						upper=0;
						lower=0;
					}
					if(upper<10){
						System.out.println(upper+" "+lower);
						System.out.flush();
					}
				}
				if(lower-upper>1){
					System.out.println("?"+lower+" "+upper);
					System.out.flush();
					String x1=sc.nextLine();
					System.out.println("?"+upper+" "+lower);
					System.out.flush();
					String x2=sc.nextLine();
					System.out.println("! "+x1==x2?lower:upper);
				}else
					System.out.println("! "+(!notX?1:(r2.equals("x")?lower:upper)));
				System.out.flush();
				s=sc.nextLine();
		}
		sc.close();
	}
}
