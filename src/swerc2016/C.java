package swerc2016;
import java.util.*;
public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long d = sc.nextLong(), r = sc.nextLong(), t = sc.nextLong();
		long a = 2;
		long b = -1 - 2 * d + 1;
		long c = -18 -2 * (r + t) + d * d - d;
		long age = (-b + (long)Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		long age2 = (-b - (long)Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		long r1 = age * (age + 1) / 2 - 6;
		long r2 = age2 * (age2 + 1) / 2 - 6;
		//System.out.println(age +"  " + age2 + " " + r1 +" " + r2);
		if(age >= d && r1 <= r)
			System.out.println(r - r1);
		else
			System.out.println(r - r2);
	}
}
