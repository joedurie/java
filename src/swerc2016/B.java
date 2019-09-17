package swerc2016;
import java.util.*;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double mx = sc.nextInt(), my = sc.nextInt();
		TreeMap<Double, Integer> map = new TreeMap<Double, Integer>();
		int ct = 0, eqCt = 0, x0 = 0, y0 = 0, yMax = 0, xMax = 0;
		for(int i = 0; i < n - 1; i++) {
			double x = sc.nextInt(), y = sc.nextInt();
			if(x > mx) y0++;
			if(y > my) x0++;
			if(x == mx) yMax++;
			if(y == my) xMax++;
			if(x == mx && y == my) {
				eqCt++;
				continue;
			}
			if(x >= mx && y >= my) {
				ct++;
				continue;
			}
			if(x <= mx && y <= my) 
				continue;
			double r = -(my - y) / (mx - x);
			double r2 = r + 0.1;
			if(mx + r2 * my > x + r2 * y) {
				ct++;
				map.put(r,map.containsKey(r) ? map.get(r) - 1 : -1);
			} else
				map.put(r, map.containsKey(r) ? map.get(r) + 1 : 1); 
		}
		//System.out.println(x0 + " " + y0 + " " + ct);
		//System.out.println(map);
		int max = ct + eqCt, min = ct;
		for(double d:map.keySet()) {
			ct += map.get(d);
			max = Math.max(ct,max);
			min = Math.min(ct,min);
		}
		int max0 = Math.max(x0 + xMax, y0 + yMax), min0 = Math.min(x0, y0);
		System.out.println((1+Math.min(min, min0)) +  " " + (1+Math.max(max0, max)));
		sc.close();
	}
}
