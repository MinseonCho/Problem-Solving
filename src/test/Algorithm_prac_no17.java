package test;

import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_prac_no17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] data = new int[N];
		for (int i = 0; i < N; i++)
			data[i] = sc.nextInt();

		int[] dp = new int[M + 1];
		Arrays.fill(dp, 10001);

		dp[0] = 0;

		for (int i : data) {
			for (int j = i; j < M + 1; j++) {
				dp[j] = Math.min(dp[j], dp[j - i] + 1);
			}
		}

		if (dp[M] != 10001)
			System.out.println(dp[M]);
		else
			System.out.println("-1");
	}

}
