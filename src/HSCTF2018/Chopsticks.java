package HSCTF2018;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class Chopsticks {
	public static void main(String[]args){
		String s=load("chopsticks.txt");
		int[]counts=new int[5];
		for(char c:s.toCharArray())
			if(c=='!')
				counts[0]++;
			else if(c=='i')
				counts[1]++;
			else if(c=='I')
				counts[2]++;
			else if(c=='l')
				counts[3]++;
			else if(c=='1')
				counts[4]++;
		int sum=0;
		for(int b=2;b<=10;b++)
			for(int i:counts)
				sum+=(int)Math.floor(Math.log(i)/Math.log(b))+1;
		System.out.println(sum);
	}
	public static String load(String fileName){
		try{
			Scanner s=new Scanner(new File(fileName));
			return s.nextLine();
		}catch(FileNotFoundException e){
			return null;
		}
	}
}