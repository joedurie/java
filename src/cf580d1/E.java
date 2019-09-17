package cf580d1;
import java.io.*;
import java.util.*;
package templates;
import java.util.*;

public class E {
	private static final long MOD = 1000000007;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		sc.close();
		long denom = pow(k, n);
		for(int i = 1; i < )
	}
	private static long pow(long a, long p) {
		if(p == 0)
			return 1;
		long l = pow(a, p/2);
		return l * l % MOD * (p % 2 == 1 ? a : 1) % MOD;
	}
	private static long inv(long x) {
		return pow(x, MOD - 2);
	}
	private static long C(int n, int k) {
		return fact[n] * inv(fact[k]) % MOD * inv(fact[n-k]) % MOD;
	}
	private static long modFrac(long n, long d) {
		long g = gcd(n, d);
		return n / g * inv(d / g) % MOD;
	}
	private static long gcd(long a, long b){
		return b == 0 ? a : gcd(b, a % b);
	}
}
