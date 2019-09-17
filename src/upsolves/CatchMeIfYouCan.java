package upsolves;
import java.util.*;
import static java.lang.Math.*;

public class CatchMeIfYouCan {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		double th1 = 0;
		Res r1 = getRes(th1);
		if(r1.d == 0) {
			th1 = PI;
			r1 = getRes(th1);
		}
		if(r1.d == 0)
			finish(PI / 2);
		else if(r1.p == 2) {
			Res r2 = getRes(th1);
			if(r2.p == 2) {
				double ans = arccos(-sqrt(5 * pow(r2.d, 2) / (16 * r1.d * (r1.d + r2.d))));
				finish(th1 < 1 ? ans : PI - ans);
			} else {
				double rad = sqrt(r1.d * r2.d * (r1.d + r2.d) / (5 * r2.d - 3 * r1.d));
				double ans = arccos((3 * pow(rad, 2) - pow(r2.d, 2)) / (2 * rad * r2.d));
				finish(th1 < 1 ? ans : PI - ans);
			}
		} else {
			double ang = acos(2/3.0) + .00001, th2 = th1 < 1 ? ang : PI - ang;
			Res r2 = getRes(th2);
			if(r2.d == 0) {
				th2 = 2 * PI - th2;
				r2 = getRes(th2);
			}
			if(r2.p == 2)
				finish((th1 < 1) == (th2 < PI) ? th2 + PI / 2 : th2 - PI / 2);
			else {
				double ans = bSearch(0, PI / 2, r1.d, r2.d, PI - ang);
				if(th1 < 1)
					finish(th2 < PI ? th2 + PI - ans : th2 - PI + ans);
				else
					finish(th2 < PI ? th2 - PI + ans: th2 - PI - ans);
			}
		}
	}
	static double arccos(double d) {
		return d > 1 ? 0 : (d < -1 ? PI : acos(d));
	}
	static double bSearch(double l, double r, double d1, double d2, double ang) {
		if(r - l < .00000000001)
			return l;
		double m = (l + r) / 2, fM = d1 * cos(m) - d2 * cos(ang - m);
		double fL = d1 * cos(l) - d2 * cos(ang - l);
		if(fL * fM < 0)
			return bSearch(l, m, d1, d2, ang);
		return bSearch(m, r, d1, d2, ang);
	}
	static double fix(double theta) {
		return 180 * ((theta % (2 * PI) + 2 * PI) % (2 * PI)) / PI;
	}
	static Res getRes(double theta) {
		System.out.printf("%.12f\n", fix(theta));
		System.out.flush();
		return new Res(sc.nextDouble(), sc.nextInt());
	}
	static void finish(double theta) {
		sc.nextLine();
		while(true) {
			System.out.printf("%.12f\n", fix(theta));
			System.out.flush();
			String s = sc.nextLine();
			if(s.equals("Gotcha!") || s.equals("The pokemon ran away!"))
				return;
			if(Double.parseDouble(s.split(" ")[0]) == 0)
				theta = 2 * PI - theta;
		}
	}
	static class Res {
		double d;
		int p;
		public Res(double dist, int paws) {
			d = dist;
			p = paws;
		}
	}
}
