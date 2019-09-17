package codejam2019;
import java.util.*;
import java.io.*;
public class Maze {
	public static void main(String[]args){
		PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int w=1;w<=t;w++){
			int n=sc.nextInt();
			sc.nextLine();
			char[]p=sc.nextLine().toCharArray();
			char[]ans=new char[p.length];
			if(p[0]=='E'&&p[p.length-1]=='S')
				for(int i=0;i<ans.length;i++)
					ans[i]=(i>=ans.length/2?'E':'S');
			else if(p[0]=='S'&&p[p.length-1]=='E')
				for(int i=0;i<ans.length;i++)
					ans[i]=(i>=ans.length/2?'S':'E');
			else if(p[0]=='S'){
				int index=0,i=1;
				while(!(p[i]==p[i-1]&&p[i]=='E')){
					if(p[i]=='E')
						ans[index++]='E';
					i++;
				}
				for(int j=0;j<n-1;j++){
					ans[index++]='S';
				}
				while(index<ans.length){
					ans[index++]='E';
				}
			}else{
				int index=0,i=1;
				while(!(p[i]==p[i-1]&&p[i]=='S')){
					if(p[i]=='S')
						ans[index++]='S';
					i++;
				}
				for(int j=0;j<n-1;j++)
					ans[index++]='E';
				while(index<ans.length)
					ans[index++]='S';
			}
			out.print("Case #"+w+": ");
			for(char c:ans)
				out.print(c);
			out.println();
		}
		sc.close();
		out.close();
	}
}
