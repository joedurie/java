package swerc2016;
import java.util.*;

public class H {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[][] pasc = new long[33][33];
		for(int i = 0; i < 33; i++) {
			pasc[i][0] = 1;
			pasc[0][i] = 1;
		}
		for(int i = 1; i < 33; i++)
			for(int j = 1; j < 33; j++)
				pasc[i][j] = pasc[i-1][j] + pasc[i][j-1];
		HashMap<Integer, TreeSet<Long>> map = new HashMap<Integer, TreeSet<Long>>();
		for(int i = 0; i < 33; i++) {
			map.put(200 + i, new TreeSet<Long>());
			for(int j = 0; j <= i; j++)
				map.get(200 + i).add(pasc[j][i - j]);
		}
		for(int d = 3; d < 33; d++) 
			for(int n = 0; n < 33; n++) {
				map.put(100 * d + n, new TreeSet<Long>());
				for(int i = 0; i <= n; i++)
					for(long x : map.get(100 * (d - 1) + i))
						map.get(100 * d + n).add(pasc[i][n - i] * x);
			}
		int D = sc.nextInt(), N = sc.nextInt() - 1;
		TreeSet<Long> set = map.get(100 * D + N);
		for(long i : set)
			System.out.println(i);
	}
}
