package HSCTF2018;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class TheGame {
	private static ArrayList<ArrayList<Integer>>tree;
	private static ArrayList<Integer>leaves;
	public static void main(String[]args){
		tree=load("thegame.txt");
		leaves=getLeaves();
		System.out.println(leaves.size());
		System.out.println((leaves.size()+1-getN(1,true))+"_"+getN(1,false));
	}
	public static ArrayList<ArrayList<Integer>> load(String fileName){
		try{
			Scanner s=new Scanner(new File(fileName));
			tree=new ArrayList<ArrayList<Integer>>();
			int n=s.nextInt();
			for(int i=0;i<n+1;i++)
				tree.add(null);
			while(s.hasNext()){
				int parent=s.nextInt();
				int child=s.nextInt();
				if(tree.get(parent)==null)
					tree.set(parent,new ArrayList<Integer>());
				tree.get(parent).add(child);
				tree.set(child,new ArrayList<Integer>());
			}
			s.close();
			return tree;
		}catch(FileNotFoundException e){
			return null;
		}
	}
	public static ArrayList<Integer>getLeaves(){
		leaves=new ArrayList<Integer>();
		for(int i=1;i<tree.size();i++)
			if(tree.get(i).size()==0)
				leaves.add(i);
		return leaves;
	}
	public static int getN(int node,boolean yourTurn){
		if(leaves.contains(node))
			return 1;
		if(yourTurn){
			int min=getN(tree.get(node).get(0),!yourTurn);
			for(int i:tree.get(node))
				min=Math.min(min,getN(i,!yourTurn));
			return min;
		}
		int sum=0;
		for(int i:tree.get(node))
			sum+=getN(i,!yourTurn);
		return sum;
	}
}