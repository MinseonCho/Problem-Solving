package test;

import java.util.*;

//병사 배치하기

public class Algorithm_prac_no380 {

	static int n;
	static int[] arr = new int[2000];
	static int[] dp = new int[2000];
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0] = 1;
		for (int k = 1; k < n; k++) {
//			dp[k] = 1;
			for (int i = 0; i < k; i++) {
				if (arr[i] > arr[k]) {
					dp[k] = Math.max(dp[k], dp[i] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(n - max);
	}

}
