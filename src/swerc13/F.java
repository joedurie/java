package swerc13;
import java.util.*;

public class F {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] a = new long[20];
		a[0] = 5;
		for(int i = 1; i < 20; i++)
			if(i % 2 == 1)
				a[i] = a[i - 1] + 2 * (long)Math.pow(5, i);
			else
				a[i] = 5 * a[i - 1];
		while(true) {
			long n = sc.nextLong();
			if(n < 0) break;
			int p = 5;
			while(n > 0) {
				for(int x = n; x % p != p - 1; x++)
			}
		}
	}
}
