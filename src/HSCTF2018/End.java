package HSCTF2018;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class End {
	public static void main(String[]args){
		File file=new File("tiles.txt");
		try{
			Scanner s=new Scanner(file);
			int row=0;
			boolean[][]tiles=new boolean[5000][10000];
			while(s.hasNext()){
				tiles[row++]=bRow(s.nextLine());
			}
			s.close();
			int[][]paths=new int[5000][5000];
			paths[4999][0]=1;
			int i=4999;
			while(tiles[i][0])
				paths[i--][0]=1;
			int j=0;
			while(tiles[4999][j])
				paths[4999][j++]=1;
			for(int r=4998;r>=0;r--)
				for(int c=1;c<5000;c++)
					if(tiles[r][c])
						paths[r][c]=(paths[r+1][c]+paths[r][c-1])%1000000007;
					else
						paths[r][c]=0;
			System.out.println(paths[0][4999]);
		}catch(FileNotFoundException e){
			System.out.println("file not found");
		}
	}
	public static boolean[]bRow(String s){
		boolean[]row=new boolean[5000];
		int i=0;
		for(int c=0;c<s.length();c++)
			if(s.charAt(c)=='0')
				row[i++]=true;
			else if(s.charAt(c)=='1')
				i++;
		return row;
	}
}