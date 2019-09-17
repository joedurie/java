package HSCTF2018;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class RiversideGames {
	private static ArrayList<ArrayList<Integer>>graph;
	private static ArrayList<Integer>usedNodes;
	public static void main(String[]args){
		try{
			Scanner s=new Scanner(new File("riversidegames.txt"));
			int wins=0;
			while(s.hasNextLine()){
				resetTo(s.nextLine().split(" "));
				if(canWin(0,new ArrayList<Integer>()))
					wins++;
			}
			s.close();
			System.out.println(wins);
		}catch(FileNotFoundException e){}
	}
	public static boolean canWin(int start,ArrayList<Integer>usedNodes){
		if(graph.get(start).isEmpty())
			return false;
		for(int i:graph.get(start))
			if(!usedNodes.contains(i)){
				usedNodes.add(i);
				if(!canWin(i,usedNodes))
					return true;
				usedNodes.remove(new Integer(i));
			}
		return false;
	}
	public static void resetTo(String[]s){
		graph=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<100;i++)
			graph.add(new ArrayList<Integer>());
		for(int i=0;i<s.length;i++){
			int n=Integer.parseInt(s[i]);
			graph.get(n).add(Integer.parseInt(s[++i]));
		}
	}
}