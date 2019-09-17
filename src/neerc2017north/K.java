package neerc2017north;
import java.util.*;
import java.io.*;
public class K {
	private static boolean works(int x,int y,int w,int h){
		return x<=(w+1)/2&&y<=(h+1)/2;
	}
	private static void fill(int x,boolean[]arr){
		for(int i=0;i<x-1;i++)
			arr[1+2*i]=true;
	}
	public static void main(String[]args) throws IOException{
		Scanner sc=new Scanner(new File("auxiliary.in"));
		FileWriter fw=new FileWriter("auxiliary.out");
		//Scanner sc=new Scanner(System.in);
		int h=sc.nextInt(),w=sc.nextInt(),n=sc.nextInt();
		if(n>(h+1)*(w+1)/4)
			fw.write("Impossible\n");
		else{
			boolean[]rows=new boolean[h];
			boolean[]cols=new boolean[w];
			boolean works=false;
			for(int i=1;i<=Math.sqrt(n);i++)
				if(n%i==0){
					if(works(i,n/i,h,w)){
						fill(i,rows);
						fill(n/i,cols);
						works=true;
						break;
					}else if(works(i,n/i,w,h)){
						fill(i,cols);
						fill(n/i,rows);
						works=true;
						break;
					}
				}
			if(!works)
				fw.write("Impossible\n");
			else{
				for(int i=0;i<h;i++){
					for(int j=0;j<w;j++)
						fw.write(rows[i]||cols[j]?"#":".");
					fw.write("\n");
				}
			}
		}
		sc.close();
		fw.close();
	}
}

