package swerc2016;
import java.util.*;

public class J {
	static double[] p;
	static double[] c;
	static double n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt() - 1;
		int m = sc.nextInt();
		p = new double[(int)m];
		c = new double[(int)m];
		for(int i = 0; i < m; i++) {
			p[i] = bSearch(0, 1, i);
			c[i] = (1 - n * p[i] * Math.pow(1 - p[i], n - 1));
			System.out.println(p[i]);
		}
		sc.close();
 	}
	public static double bSearch(double l, double r, int i) {
		double mid = (l + r) / 2;
		if(r - l < 0.000001) 
			return mid;
		double ans = fn(mid, i);
		if(ans > 0 == fn(l, i) > 0)
			return bSearch(mid, r, i);
		return bSearch(l, mid, i);
	}
	public static double fn(double x, int i) {
		double ans = 1;
		for(int j = 0; j < i; j++)
			ans *= c[i];
		ans *= Math.pow(1 - x, n);
		return ans - x;
	}
}
