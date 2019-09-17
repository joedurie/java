package HSCTF2018;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Deadfish{
	private static int[][]distanceTo;
	private static int[][]numbers;
	private static int[][]minLength;
	public static void main(String[]args){
		fillDistTo();
		load("deadfish.txt");
		minLength=new int[numbers.length][3];
		System.out.println(getMinLength());
	}
	public static int getMinLength(){
		minLength[numbers.length-1][0]=1;
		minLength[numbers.length-2][1]=1;
		minLength[numbers.length-3][2]=1;
		for(int i=numbers.length-2;i>=0;i--){
			for(int length=0;length<3;length++){
				if(i+length<numbers.length&&numbers[i][length]<257&&minLength[i][length]==0){
					minLength[i][length]=minOf(i,length)+1;
				}
			}
		}
		return Math.min(minLength[0][0]+distanceTo[0][numbers[0][0]],minLength[0][1]+distanceTo[0][numbers[0][1]]);
	}
	public static int minOf(int i,int thisLength){
		int min=Integer.MAX_VALUE;
		int thisNum=numbers[i][thisLength];
		int nextI=i+thisLength+1;
		for(int nextLength=0;nextLength<3;nextLength++){
			int nextNum=numbers[nextI][nextLength];
			if(nextNum<257&&nextNum!=0)
				if(minLength[nextI][nextLength]+distanceTo[thisNum][nextNum]<min)
					min=minLength[nextI][nextLength]+distanceTo[thisNum][nextNum];
		}
		return min;
	}
	public static void fillDistTo(){
		distanceTo=new int[257][257];
		ArrayList<Integer>list;
		for(int i=0;i<distanceTo.length;i++)
			for(int j=0;j<distanceTo.length;j++){
				list=new ArrayList<Integer>();
				list.add(i);
				int count=0;
				while(!list.contains(j)){
					ArrayList<Integer>temp=new ArrayList<Integer>();
					for(int n:list){
						temp.add((n+1)%257);
						temp.add((n+256)%257);
						temp.add((int)Math.pow(n,3)%257);
					}
					list=temp;
					count++;
				}
				distanceTo[i][j]=count;
			}
	}
	public static void load(String fileName){
		try{
			Scanner s=new Scanner(new File(fileName));
			String st=s.nextLine();
			numbers=new int[st.length()][3];
			for(int i=0;i<numbers.length;i++)
				for(int j=0;j<3;j++)
					if(i+j<numbers.length)
						numbers[i][j]=Integer.parseInt(st.substring(i,i+j+1));
			s.close();
		}catch(FileNotFoundException e){}
	}
}