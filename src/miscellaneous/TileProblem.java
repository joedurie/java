package miscellaneous;
import java.util.*;
public class TileProblem{
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),r=sc.nextInt();
		sc.close();
		boolean[]canWin=new boolean[n+1],canLose=new boolean[n+1];
		int[]levelOf=new int[n+1];
		ArrayList<Integer>minILev=new ArrayList<Integer>();
		for(int i=0;i<=n;i++){
			int lev=-1;
			do{
				lev++;
				if(lev>=minILev.size())
					minILev.add(i);
				canWin[i]=false;
				canLose[i]=i-minILev.get(lev)<r;
				for(int j=0;j<=i-r;j++)
					if(levelOf[j]==lev&&levelOf[i-r-j]==0){
						if(canWin[j]!=canLose[j]&&canWin[i-r-j]!=canLose[i-r-j]){
							if(canWin[j]==canWin[i-r-j])
								canWin[i]=true;
							else
								canLose[i]=true;
						}else if(canWin[j]==canWin[i-r-j]){
							canWin[i]=true;
							canLose[i]=true;
						}
					}else if(canWin[j]==canWin[i-r-j]&&((levelOf[j]-levelOf[i-r-j]==lev&&levelOf[i-r-j]<lev)||
							(levelOf[j]>lev&&levelOf[i-r-j]==levelOf[j]&&(lev<2||levelOf[j]>=2*lev)))){
						canWin[i]=true;
						canLose[i]=true;
					}
			}while(canWin[i]&&canLose[i]);
			levelOf[i]=lev;
			if(!canWin[i]&&levelOf[i]==0&&i>=r)
				System.out.println(i);
		}
	}
}