package northwesticpc2017;
import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		char last = '#';
		boolean odd = true;
		for(char c : s) {
			if(c == last)
				odd = false;
			last = c;
		}
		System.out.println(odd ? "Odd." : "Or not.");
		sc.close();
	}
}
