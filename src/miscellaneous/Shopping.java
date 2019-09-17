package miscellaneous;
import java.util.*;

public class Shopping {
	static int[][] next;
	static long[] a;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int q = sc.nextInt();
		a = new long[n];
		for(int i = 0; i < n; i++)
			a[i] = sc.nextLong();
		next = new int[n][log2()];
		TreeMap<Long, LinkedList<Integer>> pending = new TreeMap<Long, LinkedList<Integer>>();
		for(int i = 0; i < n; i++) {
			while(!pending.isEmpty() && pending.lastKey() > a[i]) {
				long k = pending.lastKey();
				for(int x : pending.get(k))
					next[x][0] = i;
				pending.pollLastEntry();
			}
			if(!pending.containsKey(a[i]))
				pending.put(a[i], new LinkedList<Integer>());
			pending.get(a[i]).add(i);
		}
		for(long k : pending.keySet())
			for(int x : pending.get(k))
				next[x][0] = -1;
		for(int j = 1; j < log2(); j++)
			for(int i = 0; i < n; i++)
				next[i][j] = next[i][j - 1] == -1 ? -1 : next[next[i][j - 1]][j - 1];
		for(int w = 0; w < q; w++) {
			long v = sc.nextLong();
			int l = sc.nextInt() - 1, r = sc.nextInt() - 1;
			l = nextLess(l, v);
			while(l != -1 && l <= r) {
				v %= a[l];
				l = nextLess(l, v);
			}
			System.out.println(v);
		}
	}
	static int nextLess(int ind, long val) {
		if(a[ind] < val) return ind;
		for(int i = log2() - 1; i >= 0; i--)
			if(next[ind][i] > val)
				ind = next[ind][i];
		return next[ind][0];
	}
	static int log2() {
		return (int)Math.ceil(Math.log(n) / Math.log(2));
	}
}
