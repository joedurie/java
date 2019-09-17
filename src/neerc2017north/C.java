package neerc2017north;
import java.util.*;
import java.io.*;
public class C {
	public static void main(String[]args) throws IOException{
		Scanner sc=new Scanner(new File("auxiliary.in"));
		FileWriter fw=new FileWriter("auxiliary.out");
		char[]s=sc.nextLine().toCharArray();
		String cnsts="bcdfghjklmnpqrstvxz";
		char[]cn2=cnsts.toCharArray();
		int[][]ct=new int[19][19];
		for(int i=0;i<s.length-1;i++)
			if(cnsts.indexOf(s[i])!=-1&&cnsts.indexOf(s[i+1])!=-1)
				ct[cnsts.indexOf(s[i])][cnsts.indexOf(s[i+1])]++;
		long max=0;
		long mask=0;
		for(int i=0;i<(1<<19);i++){
			long ans=0;
			for(int c=0;c<cn2.length;c++)
				for(int d=0;d<cn2.length;d++)
					if((((1<<c)&i)>0)!=(((1<<d)&i)>0))
						ans+=ct[c][d];
			if(ans>max){
				max=ans;
				mask=i;
			}
		}
		for(char c:s)
			if((mask&(1<<cnsts.indexOf(c)))>0)
				fw.write((char)(c+'A'-'a'));
			else
				fw.write(c);
		sc.close();
		fw.close();
	}
}
