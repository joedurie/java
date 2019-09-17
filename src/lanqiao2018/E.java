package lanqiao2018;
import java.util.Scanner;
public class E {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=2*sc.nextInt()-1,m=2*sc.nextInt()-1;
		boolean[][]blocked=new boolean[n][m];
		for(int r=1;r<n;r+=2)
			for(int c=1;c<m;c+=2)
				blocked[r][c]=sc.nextInt()==0;
		sc.close();
		long[][] waysTo=new long[n][m];
		for(int r=0;r<n;r++)
			waysTo[r][0]=1;
		for(int c=0;c<m;c++)
			waysTo[0][c]=1;
		for(int r=1;r<n;r++)
			for(int c=1;c<m;c++)
				if(!blocked[r][c])
					waysTo[r][c]=waysTo[r-1][c]+waysTo[r][c-1];
		long[][]badPathsAt=new long[n][m];
		long[][]sumBadPathsUnder=new long[n][m];
		for(int r=1;r<n;r++){
			badPathsAt[r][0]=1;
			sumBadPathsUnder[r][0]=r;
		}
		for(int c=1;c<m;c++){
			badPathsAt[0][c]=1;
			sumBadPathsUnder[0][c]=c;
		}
		for(int r=1;r<n;r++)
			for(int c=1;c<m;c++){
				if(!blocked[r][c]){
					badPathsAt[r][c]=waysTo[r-1][c]*waysTo[r-1][c]+waysTo[r][c-1]*waysTo[r][c-1];
					if(waysTo[r-1][c-1]>0)
						badPathsAt[r][c]+=sumBadPathsUnder[r-1][c-1];
					sumBadPathsUnder[r][c]=badPathsAt[r][c]+sumBadPathsUnder[r-1][c]+sumBadPathsUnder[r][c-1]-sumBadPathsUnder[r-1][c-1];
				}
			}
		for(long[]i:waysTo){
			for(long j:i)
				System.out.print(j);
			System.out.println();
		}
		System.out.println(":::::::::::::");
		for(long[]i:badPathsAt){
			for(long j:i)
				System.out.print(j);
			System.out.println();
		}
		System.out.println(":::::::::::::");
		for(long[]i:sumBadPathsUnder){
			for(long j:i)
				System.out.print(j);
			System.out.println();
		}
		System.out.println(waysTo[n-1][m-1]*waysTo[n-1][m-1]-badPathsAt[n-1][m-1]);
	}
}