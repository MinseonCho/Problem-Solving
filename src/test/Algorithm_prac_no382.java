package test;

import java.util.Scanner;

public class Algorithm_prac_no382 {

	static String str1 = "";
	static String str2 = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		str1 = sc.next();
		str2 = sc.next();

		System.out.println(editString(str1, str2));

	}

	static int editString(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 0; i < n + 1; i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i < m + 1; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				//���ڰ� ���ٸ�, ���� ���� �ش��ϴ� ���� �״�� ����
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					//����(����), ����(����), ��ü(���� ��) �߿��� �ּ� ����� ã�� ����
					int min = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
					dp[i][j] = min+1;
				}
			}
		}

//		for (int i = 0; i < n + 1; i++) {
//			for (int j = 0; j < m + 1; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println(" ");
//		}

		return dp[n][m];
	}

}
