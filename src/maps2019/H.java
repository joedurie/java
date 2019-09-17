package maps2019;
import java.util.*;
public class H {
	public static void main(String[]args){
		Scanner sc=new Scanner(System.in);
		char[]a=sc.nextLine().toCharArray();
		char[]b=sc.nextLine().toCharArray();
		HashSet<Character>word=new HashSet<Character>();
		for(char c:a)
			word.add(c);
		int ind=1;
		for(int i=1;i<=26;i++)
			if(word.contains(b[i-1]))
				ind=i;
		System.out.println(ind<word.size()+10?"WIN":"LOSE");
		sc.close();
	}
}
