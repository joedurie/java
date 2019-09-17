package HSCTF2018;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;
public class KeithArithmetic {
	private static boolean[]s;
	public static void main(String[]args){
		HashMap<Integer,int[]>map=load("keithArithmetic");
		long sum=0;
		for(int i:map.keySet()){
			sum+=v(S(map.get(i),i));
		}
		System.out.println(sum);
	}
	public static HashMap<Integer,int[]>load(String fileName){
		try{
			HashMap<Integer,int[]>map=new HashMap<Integer,int[]>();
			Scanner s=new Scanner(new File(fileName));
			while(s.hasNext()){
				int k=Integer.parseInt(s.next());
				String[]temp=s.next().split(" ");
				int[]p=new int[temp.length];
				for(int i=0;i<temp.length;i++){
					p[i]=Integer.parseInt(temp[i]);
				}
				map.put(k,p);
			}
			s.close();
			return map;
		}catch(FileNotFoundException e){
			return null;
		}
	}
	public static void populateS(int kMax){
		s=new boolean[kMax+1];
		for (int i=0;i<=kMax;i++)
			initializeS(i);
	}
	public static void initializeS(int i){
		if(i==0)
			s[i]=true;
		else if(i==1)
			s[i]=false;
		else
			s[i]=!s[(int)(i-Math.pow(2, Math.floor(Math.log(i)/Math.log(2))))];
	}
	public static long S(int[]f,int k){
		long sum=0;
		for(int i=0;i<=Math.pow(2,k)-1;i++)
			if(s[i])
				sum+=f(f,i);
			else
				sum-=f(f,i);
		return sum;
	}
	public static long f(int[]f,int x){
		long sum=0;
		for(int i=f.length-1;i>=0;i--)
			sum+=f[i]*Math.pow(x,f.length-1-i);
		return sum;
	}
	public static int v(long S){
		int twos=0;
		while(S%2L==0){
			twos++;
			S/=2L;
		}
		return twos;
	}
}