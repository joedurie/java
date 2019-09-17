package northwesticpc2017;
import java.util.*;

public class J2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int[] maxB = new int[m];
		int[] minR = new int[m];
		for(int i = 0; i < m; i++) {
			maxB[i] = 0;
			minR[i] = n + 1;
		}
		sc.nextLine();
		long[][] dp = new long[m][n + 1];
		for(int i = 0; i < n; i++) {
			char[] line = sc.nextLine().toCharArray();
			for(int j = 0; j < m; j++)
				if(line[j] == 'R')
					minR[j] = Math.min(minR[j], i + 1);
				else if(line[j] == 'B')
					maxB[j] = Math.max(maxB[j], i + 1);
		}
		sc.close();
		for(int i = maxB[0]; i < minR[0]; i++)
			dp[0][i] = 1;
		for(int j = 1; j < m; j++)
			for(int i = maxB[j]; i < minR[j]; i++)
				for(int k = i; k < n + 1; k++)
					dp[j][i] += dp[j - 1][k];
		long ans = 0;
		for(int i = 0; i < n + 1; i++)
			ans += dp[m - 1][i];
		System.out.println(ans);
	}
}
