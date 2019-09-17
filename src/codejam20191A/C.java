package codejam20191A;
import java.util.*;
public class C {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int w=1;w<=t;w++){
			int r=sc.nextInt(),c=sc.nextInt();
			if(r*c<10)
				System.out.println("Case "+w+": IMPOSSIBLE");
			else{
				System.out.println("Case "+w+": POSSIBLE");
				int min=Math.min(r,c),max=Math.max(r,c);
				if(min==2){
					int r0=2,c0=3;
					System.out.println(min==r?"2 3":"3 2");
					while(!(r0==1&&c0==max-2)){
						if(r0==1)
							c0+=3;
						else
							c0-=2;
						r0=3-r0;
						System.out.println(min==r?r0+" "+c0:c0+" "+r0);
					}
					if(min==r)
						System.out.println("2 1\n1 "+(c-1)+"\n2 2\n1 "+c);
					else
						System.out.println("1 2\n"+(r-1)+" 1\n2 2\n"+r+" 1");
				}else{
					for(int j=1;j<=max-2;j++)
						for(int i=1;i<=min;i++)
							System.out.println(max==c?(i+" "+(i%2==1?j:j+2)):((i%2==1?j:j+2)+" "+i));
					for(int i=1;i<=min;i++)
						System.out.println(max==c?(i+" "+(i%2==1?max-1:(max==min&&max!=4?2:1))):((i%2==1?max-1:(max==min&&max!=4?2:1))+" "+i));
					if(max==min&&max==4)
						System.out.println("3 4\n4 2\n1 4\n2 2");
					else
						for(int i=1;i<=min;i++)
							System.out.println(max==c?(i+" "+(i%2==1?max:(max==min?1:2))):((i%2==1?max:(max==min?1:2))+" "+i));
				}
			}
		}
		sc.close();
	}
}
