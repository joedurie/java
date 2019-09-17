package miscellaneous;
import java.io.*;
public class HackGenerator {
	public static void main(String[]args) throws FileNotFoundException{
		PrintWriter out=new PrintWriter("hack.txt");
		out.println("1000 1000");
		String[]a={"DAMI","AMID","MIDA","IDAM"};
		for(int i=0;i<1000;i++){
			for(int j=0;j<250;j++)
				out.print(a[i%4]);
			out.println();
		}
	}
}
