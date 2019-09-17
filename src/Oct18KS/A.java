package Oct18KS;
import java.util.*;
import java.io.*;
public class A{
	public static void main(String[]args) throws FileNotFoundException{
		Scanner sc=new Scanner(new File("input_file.txt"));
		PrintWriter out=new PrintWriter("oct18a-output.txt");
		int t=sc.nextInt();
		for(int i=1;i<=t;i++){
			int n=sc.nextInt();
			TreeMap<Integer,Integer>table=new TreeMap<Integer,Integer>();
			for(int j=0;j<n;j++){
				int num=sc.nextInt();
				if(table.containsKey(num))
					table.put(num,table.get(num)+1);
				else
					table.put(num,1);
			}
			long sum=0;
			while(!table.isEmpty()){
				int x=table.firstKey();
				int xN=table.get(x);
				table.pollFirstEntry();
				if(x==1){
					sum+=xN*(xN-1)*(xN-2)/6;
					for(int y:table.keySet())
						sum+=xN*table.get(y)*(table.get(y)-1)/2;
				}else{
					if(table.containsKey(x*x))
						sum+=table.get(x*x)*xN*(xN-1)/2;
					for(int y:table.keySet())
						if(table.containsKey(x*y))
							sum+=xN*table.get(y)*table.get(x*y);
				}
			}
			out.println("Case #"+i+": "+sum);
		}
		sc.close();
		out.close();
	}
}