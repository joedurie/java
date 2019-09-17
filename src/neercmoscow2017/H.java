package neercmoscow2017;
import java.util.*;

public class H {
	static boolean minOvf = false, maxOvf = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long t = sc.nextLong(), n = sc.nextLong();
		int m = sc.nextInt();
		long[] times = new long[m];
		long[] heat = new long[m];
		for(int i = 0; i < m; i++) {
			times[i] = sc.nextLong();
			heat[i] = sc.nextLong();
		}
		sc.close();
		long minT = fMin(0, times[0], 0, heat[0]);
		long maxT = times[0] * heat[0];
		boolean works = true;
		for(int i = 0; i < m - 1; i++) {
			long min = fMin(times[i], times[i + 1], heat[i], heat[i + 1]);
			long max = fMax(times[i], times[i + 1], heat[i], heat[i + 1]);
			if(min == -1 || max == -1)
				works = false;
			minT = add(minT, min, false);
			maxT = add(maxT, max, true);
		}
		minT = add(minT, times[m - 1] * heat[m - 1], false);
		maxT = add(maxT, n - )
		System.out.println(minT + " " + maxT);
		boolean ans = works && !minOvf && (maxOvf || t >= minT && t <= maxT);
		System.out.println(ans ? "Yes" : "No");
	}
	public static long add(long a, long b, boolean max) {
		long ans = a + Math.max(b, 0);
		if(ans < 0 && max)
			maxOvf = true;
		else if(ans < 0)
			minOvf = true;
		return ans;
	}
	public static long fMin(long t1, long t2, long ha, long hb) {
		long hMax = Math.max(ha, hb), hMin = Math.max(ha, hb);
		if(hMax - hMin > t2 - t1) return -1;
		return (t2 - t1) * hMin + sum(hMax - hMin);
	}
	public static long fMax(long t1, long t2, long ha, long hb) {
		long hMax = Math.max(ha, hb), hMin = Math.max(ha, hb);
		if(hMax - hMin > t2 - t1) return -1;
		return (t2 - t1) * hMax - sum(hMax - hMin);
	}
	public static long sum(long x) {
		return x * (x + 1) / 2;
	}
}
