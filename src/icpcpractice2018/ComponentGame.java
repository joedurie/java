package icpcpractice2018;
import java.util.*;
public class ComponentGame {
	public static int[][]grid;
	public static int[][]component;
	public static LinkedList<int[]>queue=new LinkedList<int[]>();
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),m=sc.nextInt();
		sc.nextLine();
		grid=new int[n][m];
		for(int i=0;i<n;i++){
			String s=sc.nextLine();
			for(int j=0;j<m;j++)
				grid[i][j]=Integer.parseInt(""+s.charAt(j));
		}
		sc.close();
		component=new int[n][m];
		int comp=1;
		int whiteCt=0,blackCt=0;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(component[i][j]==0){
					queue.add(new int[]{i,j});
					fillComponent(comp++);
					if(grid[i][j]==0)
						whiteCt++;
					else
						blackCt++;
				}
		int[]singColWComps=new int[comp-1];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				if(grid[i][j]==0){
					if(singColWComps[component[i][j]-1]==0)
						singColWComps[component[i][j]-1]=j;
					else if(singColWComps[component[i][j]-1]!=j)
						singColWComps[component[i][j]-1]=-1;
				}else
					singColWComps[component[i][j]-1]=-1;
		int maxBlack=0,maxWhite=0;
		for(int j=0;j<m;j++){
			HashSet<Integer>bComps=new HashSet<Integer>();
			HashMap<Integer,HashSet<int[]>>wCompSplits=new HashMap<Integer,HashSet<int[]>>();
			for(int i=0;i<n;i++){
				if(grid[i][j]==1)
					bComps.add(component[i][j]);
				if(j>0){
					if(grid[i][j-1]==1)
						bComps.add(component[i][j-1]);
					else if(grid[i][j]==0){
						if(!wCompSplits.containsKey(component[i][j-1])){
							wCompSplits.put(component[i][j-1],new HashSet<int[]>());
							wCompSplits.get(component[i][j-1]).add(new int[]{i,j-1});	
						}else{
							boolean found=false;
							for(int[]arr:wCompSplits.get(component[i][j-1]))
								if(find(i,j-1,new HashSet<String>(),arr[0],arr[1],j)){
									found=true;
									break;
								}
							if(!found)
								wCompSplits.get(component[i][j-1]).add(new int[]{i,j-1});
						}
					}
				}
				if(j<m-1){
					if(grid[i][j+1]==1)
						bComps.add(component[i][j+1]);
					else if(grid[i][j]==0){
						if(!wCompSplits.containsKey(component[i][j+1])){
							wCompSplits.put(component[i][j+1],new HashSet<int[]>());
							wCompSplits.get(component[i][j+1]).add(new int[]{i,j+1});	
						}else{
							boolean found=false;
							for(int[]arr:wCompSplits.get(component[i][j+1]))
								if(arr[1]==j+1&&find(i,j+1,new HashSet<String>(),arr[0],arr[1],j)){
									found=true;
									break;
								}
							if(!found)
								wCompSplits.get(component[i][j+1]).add(new int[]{i,j+1});
						}
					}
				}
			}
			int dWhite=0;
			for(int c:singColWComps)
				if(c==j)
					dWhite--;
			for(int i:wCompSplits.keySet())
				dWhite+=wCompSplits.get(i).size()-1;
			int regionCt=whiteCt+dWhite+blackCt-bComps.size()+1;
			if(regionCt>maxBlack+maxWhite||(regionCt==maxBlack+maxWhite&&whiteCt+dWhite>maxWhite)){
				maxWhite=whiteCt+dWhite;
				maxBlack=blackCt-bComps.size()+1;
			}
		}
		System.out.println(maxWhite+" "+maxBlack);
	}
	public static void fillComponent(int comp){
		while(!queue.isEmpty()){
			int[]coords=queue.removeFirst();
			int i=coords[0],j=coords[1];
			component[i][j]=comp;
			if(i>0&&component[i-1][j]==0&&grid[i-1][j]==grid[i][j])
				queue.add(new int[]{i-1,j});
			if(i<grid.length-1&&component[i+1][j]==0&&grid[i+1][j]==grid[i][j])
				queue.add(new int[]{i+1,j});
			if(j>0&&component[i][j-1]==0&&grid[i][j-1]==grid[i][j])
				queue.add(new int[]{i,j-1});
			if(j<grid[i].length-1&&component[i][j+1]==0&&grid[i][j+1]==grid[i][j])
				queue.add(new int[]{i,j+1});
		}
	}
	public static boolean find(int i1,int j1,HashSet<String>used,int i2,int j2,int col){
		if(i1<0||j1<0||i1>=grid.length||j1>=grid[i1].length||j1==col||grid[i1][j1]==1||used.contains(i1+" "+j1))
			return false;
		if(i1==i2&&j1==j2)
			return true;
		used.add(i1+" "+j1);
		return find(i1+1,j1,used,i2,j2,col)||find(i1-1,j1,used,i2,j2,col)||find(i1,j1+1,used,i2,j2,col)||find(i1,j1-1,used,i2,j2,col);
	}
}