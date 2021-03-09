package test;

import java.util.Scanner;
//Á¤¼ö »ï°¢Çü
public class Algorithm_prac_no376 {

	static int testCase, high;
	static int[][] dp = new int[500][500];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		high = sc.nextInt();
		for (int i = 0; i < high; i++) {
			for (int j = 0; j < i + 1; j++) {
				int tmp = sc.nextInt();
				int left, right;
				int max = 0;
				if (i == 0 && j == 0) {
					max = 0;
				} else {
					if (j == 0) {
						left = 0;
						right = dp[i - 1][j];
						max = Math.max(left, right);
					} else if (i == j) {
						left = dp[i - 1][j - 1];
						right = 0;
						max = Math.max(left,  right);
					} else {
						left = dp[i - 1][j - 1];
						right = dp[i - 1][j];
						max = Math.max(left, right);
					}
				}
				dp[i][j] = tmp + max;
			}
		}
		
		System.out.println(" ");
		for (int i = 0; i < high; i++) {
			for (int j = 0; j < high; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
		int result = 0;
		for (int i = 0; i < high; i++) {
			if(result < dp[high -1][i])
				result = dp[high -1][i];
		}
		
		System.out.println(result);
	}

}
