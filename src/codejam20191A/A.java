package codejam20191A;
import java.util.*;
public class A {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int w=1;w<=t;w++){
			int n=sc.nextInt();
			sc.nextLine();
			Node start=new Node();
			for(int i=0;i<n;i++){
				char[]s=sc.nextLine().toCharArray();
				Node curr=start;
				for(int c=s.length-1;c>=0;c--){
					curr.addChild(s[c]);
					curr=curr.children.get(s[c]);
				}
			}
			System.out.println("Case #"+w+": "+numTwos(start)[0]);
		}
		sc.close();
	}
	private static int[] numTwos(Node n){
		int ans=0,rem=n.f,deads=0;
		for(char c:n.children.keySet()){
			if(n.children.get(c).f<2){
				deads+=n.children.get(c).f;
			}else if(n.children.get(c).f==2){
				ans+=2;
				rem-=2;
			}else{
				int[]nT=numTwos(n.children.get(c));
				ans+=nT[0];
				rem-=nT[0];
				deads+=nT[1];
			}
		}
		if(rem>=2&&rem-deads<=2)
			ans+=2;
		return new int[]{ans,deads};
	}
	private static class Node{
		int f;
		HashMap<Character,Node>children;
		public Node(){
			f=1;
			children=new HashMap<Character,Node>();
		}
		private void addChild(char val){
			if(children.containsKey(val))
				children.get(val).f++;
			else
				children.put(val,new Node());
		}
		public String toString(){
			return f+" -> "+children;
		}
	}
}
