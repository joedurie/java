package cfed59;
import java.util.*;

public class E {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String s=sc.nextLine()+".";
		int[]a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		sc.close();
		ArrayList<Integer>cts=new ArrayList<Integer>();
		int len=0;
		char last='.';
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==last)
				len++;
			else{
				if(len>0)
					cts.add(len);
				len=1;
			}
			last=s.charAt(i);
		}
		int[]c=new int[n];
		for(int i=0;i<n;i++){
			int max=a[i];
			for(int j=0;j<i;j++)
				max=Math.max(c[j]+c[i-j-1],max);
			c[i]=max;
		}
		/*for(int i:cts)
			System.out.println(i);
		for(int i:c)
			System.out.println("C"+i);*/
		
	}
}
