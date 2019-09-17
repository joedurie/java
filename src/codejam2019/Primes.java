package codejam2019;
import java.util.*;
public class Primes {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int w=1;w<=t;w++){
			int n=sc.nextInt(),l=sc.nextInt();
			long[]arr=new long[l];
			for(int i=0;i<l;i++)
				arr[i]=sc.nextLong();
			long[]ans=new long[l+1];
			long[]ans2=new long[l+1];
			ArrayList<Long>primes=new ArrayList<Long>();
			for(long i=2;i<=n;i++)
				if(arr[0]%i==0){
					ans2[0]=i;
					ans2[1]=arr[0]/i;
					ans[0]=arr[0]/i;
					ans[1]=i;
					primes.add(i);
					if(!primes.contains(arr[0]/i))
						primes.add(arr[0]/i);
					break;
				}
			for(int i=1;i<l;i++){
				if(ans[i-1]==-1||arr[i]%ans[i]!=0){
					ans[i]=-1;
					ans[i+1]=-1;
				}else{
					ans[i+1]=arr[i]/ans[i];
					if(!primes.contains(arr[i]/ans[i]))
						primes.add(arr[i]/ans[i]);
				}
				if(ans2[i-1]==-1||arr[i]%ans2[i]!=0){
					ans2[i]=-1;
					ans2[i+1]=-1;
				}else{
					ans2[i+1]=arr[i]/ans2[i];
					if(!primes.contains(arr[i]/ans2[i]))
						primes.add(arr[i]/ans2[i]);
				}
			}
			System.out.print("Case #"+w+": ");
			Collections.sort(primes);
			if(ans[l]==-1)
				for(long i:ans2)
					System.out.print((char)(primes.indexOf(i)+'A'));
			else
				for(long i:ans)
					System.out.print((char)(primes.indexOf(i)+'A'));
			System.out.println();
		}
		sc.close();
	}
}
