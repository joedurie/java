package neerc2017;
import java.util.*;
public class E {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
		int wilds=0;
		ArrayList<Integer>wildList=new ArrayList<Integer>();
		boolean possible=true;
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			if(x==0)
				wilds++;
			else if(x>0)
				map.put(x,map.containsKey(x)?map.get(x)+1:1);
			else if(map.containsKey(-1*x)){
				map.put(-1*x,map.get(-1*x)-1);
				if(map.get(-1*x)==0)
					map.remove(-1*x);
			}else if(wilds>0){
				wilds--;
				wildList.add(-1*x);
			}else
				possible=false;
		}
		while(wilds>0){
			wilds--;
			wildList.add(1);
		}
		if(!possible)
			System.out.println("No");
		else{
			System.out.println("Yes");
			for(int i:wildList)
				System.out.print(i+" ");
			System.out.println();
		}
		sc.close();
	}
}
