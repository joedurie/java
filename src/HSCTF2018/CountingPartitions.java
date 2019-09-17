package HSCTF2018;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
public class CountingPartitions {
	public static void main(String[]args){
		try{
			Scanner s=new Scanner(new File("countingPartitions.txt"));
			//int maxN=500000,maxK=500000;
			//long[][]numOfOddPs=new long[maxN+1][maxK];
			//long[][]numOfEvenPs=new long[maxN+1][maxK];
			//fill(numOfOddPs,numOfEvenPs);
			HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
			while(s.hasNextInt())
				map.put(s.nextInt(),s.nextInt());
			s.close();
			long sum=0;
			for(int i:map.keySet()){
				sum+=numOfPartitions(i,map.get(i));
				System.out.print("One done.");
			}
			System.out.println(sum);
		}catch(FileNotFoundException e){
			System.out.println("file not found");
		}
	}
	public static void fill(long[][]odds,long[][]evens){
		for(int k=0;k<odds[0].length;k++){
			odds[0][k]=0;
			evens[0][k]=0;
			odds[1][k]=1;
			evens[1][k]=0;
		}
		for(int n=2;n<odds.length;n++){
			for(int k=0;k<odds[n].length;k++)
				for(int i=0;i<=Math.min(k,n);i++){
					odds[n][k]+=evens[n-i][i];
					evens[n][k]+=odds[n-i][i];
					if(i!=0){
						odds[n][k]++;
						evens[n][k]++;
					}
				}
		}
	}
	public static long numOfPartitions(int n,int k){
		long sum=0;
		for(int p=0;p<n-k;p++)
			sum+=numOfPartitions(n,k,p);
		return sum;
	}
	public static long numOfPartitions(int n, int k, int p){
		long sum=0;
		for(int i=(int)Math.ceil(n/(double)(p-1));i<Math.min(n, k);i++){
			sum+=numOfPartitions(n-i,i,p-1);
		}
		return sum;
	}
}