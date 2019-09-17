package neerc2017north;
import java.util.*;
import java.io.*;
public class E2 {
	static int I=0;
	static int[]arr;
	private static void pr(int x,int n){
		for(int i=0;i<n;i++){
			if(arr[I]==0||arr[I]>x)
				arr[I]=x;
			I++;
		}
	}
	public static void main(String[]args) throws IOException{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
		HashSet<Integer>factors=new HashSet<Integer>();
		for(int i=0;i<n;i++){
			int x=sc.nextInt();
			if(map.containsKey(x))
				map.put(x,map.get(x)+1);
			else{
				map.put(x,1);
				if(x!=1)
					factors.add(1);
				for(int j=2;j<=Math.sqrt(x);j++)
					if(x%j==0){
						factors.add(j);
						factors.add(x/j);
					}
			}
		}
		LinkedList<Integer>hasMults=new LinkedList<Integer>();
		LinkedList<Integer>noMults=new LinkedList<Integer>();
		LinkedList<Integer>third=new LinkedList<Integer>();
		for(int i:map.keySet()){
			if(factors.contains(i))
				hasMults.add(map.get(i));
			else
				noMults.add(map.get(i));
			third.add(map.get(i));
		}
		Collections.sort(hasMults);
		Collections.sort(noMults);
		Collections.sort(third);
		boolean lcm=false;
		int ans=map.size();
		arr=new int[n+1];
		if(third.size()==1)
			pr(1,third.pollFirst());
		else{
			pr(ans--,third.pollFirst()+third.pollFirst());
			while(!third.isEmpty())
				pr(ans--,third.pollFirst());
		}
		I=0;
		ans=map.size();
		while(!hasMults.isEmpty()||!noMults.isEmpty())
			if(lcm){
				if(noMults.isEmpty()||(!hasMults.isEmpty()&&hasMults.getFirst()<noMults.getFirst()))
					pr(ans--,hasMults.pollFirst());
				else
					pr(ans--,noMults.pollFirst());
			}else{
				if(!hasMults.isEmpty()&&noMults.size()<2)
					pr(ans--,hasMults.pollFirst());
				else if(noMults.size()<2)
					pr(ans--,noMults.pollFirst());
				else{
					int x=noMults.pollFirst(),y=noMults.pollFirst();
					noMults.addFirst(y);
					noMults.addFirst(x);
					if(hasMults.isEmpty()||x+y<hasMults.getFirst()){
						pr(ans--,noMults.pollFirst()+noMults.pollFirst());
						lcm=true;
					}else
						pr(ans--,hasMults.pollFirst());
				}
			}
		arr[n]=1;
		for(int i:arr)
			System.out.print(i+" ");
		System.out.println();
		sc.close();
		//fw.close();
	}
}

