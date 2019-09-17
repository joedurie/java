package templates;
import java.util.*;

public class SegtreeOriginalVer {
	static int n;
	static int[] a;
	static int[] segtree;
	static int[] pending;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		segtree = new int[4 * n];
		pending = new int[4 * n];
		getSegtree(1, 0, n - 1);
		int m = sc.nextInt();
		for(int i = 0; i < m; i++){
			//update and/or query as needed
			//queries can be performed as "updates" with x == 0 (or equivalent)
		}
		sc.close();
	}
	public static int update(int i, int l, int r, int qL, int qR, int x) {
		if(pending[i] > 0 && l != r) {
			//propagate pending[i] to pending[2 * i] and pending[2 * i + 1]
			//apply pending changes to segtree[i];
			pending[i] = 0;
		}
		if(qR < l && qR >= r)
			return 0;
		if(qL <= l && qR >= r){
			//"add" x to pending[2 * i], pending[2 * i + 1]
			return segtree[i]; // = updated value with x;
		}
		int m = (l + r) / 2;
		return segtree[i] = update(2 * i, l, m, qL, qR, x) + update(2 * i + 1, m + 1, r, qL, qR, x);
		//is adding the right way to combine values?
	}
	public static int getSegtree(int i, int l, int r) {
		if(l == r)
			return segtree[i] = a[i];
		else {
			int m = (l + r) / 2;
			return segtree[i] = getSegtree(2 * i, l, m) + getSegtree(2 * i + 1, m + 1, r);
			//is adding the right way to combine values?
		}
	}
}

