package lanqiao2018;
import java.util.Scanner;
public class A {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[]money=new int[3];
		for(int i=0;i<n;i++){
			int[]plays={sc.nextInt(),sc.nextInt(),sc.nextInt()};
			if(moneyChanges(plays))
				changeMoney(plays,money);
		}
		for(int i:money)
			System.out.println(i);
		sc.close();
	}
	public static boolean moneyChanges(int[]plays){
		if(plays[0]==plays[1]&&plays[1]==plays[2])
			return false;
		if(plays[0]!=plays[1]&&plays[1]!=plays[2]&&plays[2]!=plays[0])
			return false;
		return true;
	}
	public static void changeMoney(int[]plays,int[]money){
		int oddOneOut=0;
		if(plays[0]==plays[2])
			oddOneOut=1;
		if(plays[0]==plays[1])
			oddOneOut=2;
		int oddOneWins=-1;
		if(wins(plays[oddOneOut],plays[(oddOneOut+1)%3]))
			oddOneWins=1;
		for(int i=0;i<money.length;i++)
			if(i==oddOneOut)
				money[i]+=2*oddOneWins;
			else
				money[i]-=oddOneWins;
	}
	public static boolean wins(int play1,int play2){
		if(play1==play2-1||(play1==2&&play2==0))
			return true;
		return false;
	}
}