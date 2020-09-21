package test;

import java.util.Scanner;

public class Algorithm_prac_no14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		int cnt;
		int[] dp = new int[X + 1];

		for (int i = 2; i < X + 1; i++) {
			dp[i] = dp[i - 1] + 1; // 현재 수에서 1을 빼는 경우
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if (i % 5 == 0)
				dp[i] = Math.min(dp[i], dp[i / 5] + 1);
		}

		System.out.println("result : " + dp[X]);
	}
}
