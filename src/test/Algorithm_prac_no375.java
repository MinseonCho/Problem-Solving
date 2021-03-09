package test;

import java.util.Scanner;
//�ݱ�
public class Algorithm_prac_no375 {

	static int testCase, n, m;
	static int[][] arr = new int[20][20];
	static int[][] dp = new int[20][20];

	// ������ ��, ������, ������ �Ʒ�
	static int[] valueX = { -1, 0, 1 };
	static int[] valueY = { 1, 1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 0; tc < testCase; tc++) {

			n = sc.nextInt();
			m = sc.nextInt();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					dp[i][j] = arr[i][j];
				}
			}

			for (int j = 1; j < m; j++) {
				for (int i = 0; i < n; i++) {
					int leftUp, leftDown, left;
					// ���� ������ ���� ���
					if (i == 0)
						leftUp = 0;
					else
						leftUp = dp[i - 1][j - 1];
					// ���ʿ��� ���� ���
					left = dp[i][j - 1];
					// ���� �Ʒ����� ���� ���
					if (i == n - 1)
						leftDown = 0;
					else
						leftDown = dp[i + 1][j - 1];

					dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));

				}
			}
			
			int result = 0;
			for (int i = 0; i < n; i++) {
				result = Math.max(result, dp[i][m - 1]);
			}
			System.out.println(result);
		}

	}

}
