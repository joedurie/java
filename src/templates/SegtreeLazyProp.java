package templates;
import java.util.*;

public class SegtreeLazyProp {
	static int n;
	static int[] seg;
	static int[] pend;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		seg = new int[2 * n];
		for(int i = n; i < 2 * n; i++)
			seg[i] = sc.nextInt();
		for(int i = n - 1; i >= 0; i--)
			seg[i] = seg[2 * i] + seg[2 * i + 1]; //change operation as needed
		int m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			update(0, 9,1);
			//point/range update/query as needed
			//point updates/queries can be carried out as range updates/queries with l == r
		}
		sc.close();
	}
	public static int update(int l, int r, int x) {
		int ans = 0;
		for(l += n, r += n; l <= r; l /= 2, r /= 2) {
			System.out.println(l+" "+r);
			if(l % 2 == 1)
				ans += seg[l++];
			if(r % 2 == 0)
				ans += seg[r--];
		}
		return ans;
	}
}
