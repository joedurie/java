package neercmoscow2017;
import java.util.*;

public class G {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		long[][] r = new long[n][m];
		long[][] c = new long[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++) {
				r[i][j] = sc.nextInt();
				c[i][j] = sc.nextInt();
			}
		sc.close();
		long[][] a = new long[n][m];
		for(int i = 1; i < n; i++)
			a[i][0] = a[i - 1][0] + r[i][0];
		for(int j = 1; j < m; j++)
			a[0][j] = a[0][j - 1] - c[0][j];
		boolean ok = true;
		for(int i = 1; i < n; i++)
			for(int j = 1; j < m; j++) {
				long x = a[i - 1][j] + r[i][j];
				long y = a[i][j - 1] - c[i][j];
				if(x != y)
					ok = false;
				a[i][j] = x;
			}
		for(int i = 0; i < n; i++)
			if(a[i][0] != a[i][m - 1] - c[i][0])
				ok = false;
		for(int j = 0; j < m; j++)
			if(a[0][j] != a[n - 1][j] + r[0][j])
				ok = false;
		System.out.println(ok ? "Yes" : "No");
	}
}
