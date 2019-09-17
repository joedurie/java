package miscellaneous;
import java.util.*;

public class SaintJohnFestival {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		TreeSet<Point> top = new TreeSet<Point>();
		TreeSet<Point> bot = new TreeSet<Point>();
		for(int i = 0; i < n; i++){
			Point p = new Point(sc.nextInt(), sc.nextInt());
			insert(p, top);
			insert(p.opp(), bot);
		}
		int m = sc.nextInt(), ans = 0;
		for(int i = 0; i < m; i++) {
			Point p = new Point(sc.nextInt(), sc.nextInt());
			if(!onHull(p, top) && !onHull(p.opp(), bot))
				ans++;
		}
		System.out.println(top);
		System.out.println(bot);
		System.out.println(ans);
		sc.close();
	}
	public static boolean onHull(Point p, TreeSet<Point> hull) {
		return p.cross(hull.floor(p), hull.ceiling(p)) > 0;
	}
	public static void insert(Point p, TreeSet<Point> hull){
		Point bef = hull.floor(p), aft = hull.ceiling(p);
		if(p.cross(bef, aft) > 0) {
			hull.add(p);
			fixBad(hull, bef, true);
			fixBad(hull, aft, false);
		}
	}
	public static void fixBad(TreeSet<Point> hull, Point p, boolean left) {
		if(p != null) {
			hull.remove(p);
			Point bef = hull.floor(p), aft = hull.ceiling(p);
			if(p.cross(bef, aft) > 0)
				hull.add(p);
			else
				fixBad(hull, left ? bef : aft, left);
		}
	}
	public static class Point implements Comparable<Point> {
		int x, y;
		public Point(int X, int Y){
			x = X;
			y = Y;
		}
		public Point opp(){
			return new Point(-x, -y);
		}
		public int compareTo(Point p) {
			return x == p.x ? y - p.y : x - p.x;
		}
		public int cross(Point p1, Point p2){
			if(p1 == null || p2 == null)
				return 1;
			return (p1.x - x) * (p2.y - y) - (p1.y - y) * (p2.x - x);
		}
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
}
