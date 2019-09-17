package HSCTF2018;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class MasochistKeith {
	public static void main(String[]args){
		ArrayList<Point>coords=load("masochistKeith.txt");
		double maxDist=0;
		for(Point p:coords)
			for(Point q:coords)
				if(p.distanceTo(q)>maxDist)
					maxDist=p.distanceTo(q);
		System.out.println(maxDist);
	}
	public static ArrayList<Point>load(String fileName){
		try{
			Scanner s=new Scanner(new File(fileName));
			ArrayList<Point>list=new ArrayList<Point>();
			while(s.hasNextLine()){
				String[]arr=s.nextLine().split(" ");
				double x=Double.parseDouble(arr[0]);
				double y=Double.parseDouble(arr[1]);
				if(Math.abs(x)>850&&Math.abs(y)>850){
					list.add(new Point(x,y));
				}
			}
			return list;
		}catch(FileNotFoundException e){
			return null;
		}
	}
}