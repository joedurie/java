package northwesticpc2017;
import java.util.*;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong(), b = sc.nextLong();
		System.out.println(f(b) - f(a - 1));
		sc.close();
	}
	public static long f(long n) {
		long ans = 0;
		for(long denom = 1; denom < n; denom++){
			long last = n / denom;
			long next = (n / (denom + 1)) + 1;
			ans += denom * (next - last + 1);
		}
		return ans;
	}
}
