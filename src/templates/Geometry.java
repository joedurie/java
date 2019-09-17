package templates;
import java.util.*;
import static java.lang.Math.*;

public class Geometry {
	static double eps = 0.00000001;
	public static class P { //replace everything with ints/longs as needed
		double x, y;
		public P(double X, double Y) {
			x = X;
			y = Y;
		}
		public P neg() {
			return new P(-x, -y);
		}
		public double dist(P p) {
			return len(vec(p));
		}
		public P vec(P p) {
			return new P(p.x - x, p.y - y);
		}
		public P norm(double l) {
			return new P(x * l / len(this), y * l / len(this));
		}
		public static double len(P p) {
			return sqrt(p.x * p.x + p.y * p.y);
		}
		public double dot(P p) {
			return x * p.x + y * p.y;
		}
		public double cross(P p) {
			return x * p.y - y * p.x;
		}
		public boolean onLine(Line l) {
			return abs(vec(l.p).cross(l.d)) < eps;
		}
		public double dist(Line l) {
			return sqrt(pow(len(vec(l.p)), 2) - pow(vec(l.p).dot(l.d), 2));
		}
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	public static class Line {
		P p, d;
		public Line(P a, P b) {
			p = a;
			d = a.vec(b);
		}
		public Line(P a, double theta) {
			p = a;
			d = new P(cos(theta), sin(theta));
		}
		public double theta() {
			return atan2(d.y, d.x);
		}
		public Double m() {
			return abs(d.x) < eps ? null : d.y / d.x;
		}
		public Double b() {
			return m() == null ? null : p.y - p.x * d.y / d.x;
		}
		public P intsct(Line l) {
			if((theta() - l.theta() + 2 * PI) % (2 * PI) < eps)
				return null;
			double g = (l.d.cross(l.p) - l.d.cross(p)) / l.d.cross(d);
			return new P(p.x + g * d.x, p.y + g * d.y);
		}
		public double yOf(double x){
			return m() == null ? null : m() * x + b();
		}
		public String toString() {
			return p + " + " + d + "t";
		}
	}
}
