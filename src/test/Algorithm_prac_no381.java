package test;

import java.util.Scanner;

public class Algorithm_prac_no381 {
	static int n;
	static int[] ugly = new int[1000]; // ������ ���� ��� ���� ���̺� (1���� DP ���̺�)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		// 2��, 3��, 5�踦 ���� �ε���
		int i2 = 0, i3 = 0, i5 = 0;
		// ó���� ���� ���� �ʱ�ȭ
		int next2 = 2, next3 = 3, next5 = 5;

		ugly[0] = 1; // ù ��° ������ ���� 1
		// 1���� n������ ������ ������ ã��
		for (int l = 1; l < n; l++) {
			// ������ ���� ��� �߿��� ���� ���� ���� ����
			ugly[l] = Math.min(next2, Math.min(next3, next5));
			// �ε����� ���� ���� ����� ����
			if (ugly[l] == next2) {
				i2 += 1;
				next2 = ugly[i2] * 2;
			}
			if (ugly[l] == next3) {
				i3 += 1;
				next3 = ugly[i3] * 3;
			}
			if (ugly[l] == next5) {
				i5 += 1;
				next5 = ugly[i5] * 5;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(ugly[i] + " ");
		}
		System.out.println(" ");
		// n��° ������ ���� ���
		System.out.println(ugly[n - 1]);
	}
//	static int n;
//	static int[] dp = new int[1001];
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//
//		n = sc.nextInt();
//
//		dp[1] = 1;
//
//		for (int i = 2; i < n + 1; i++) {
//			int num = dp[i - 1] + 1;
//			int tmp = num;
//			while (tmp != 1) {
//				if (tmp % 2 == 0) {
//					tmp /= 2;
//					continue;
//				} else if (tmp % 3 == 0) {
//					tmp /= 3;
//					continue;
//				} else if (tmp % 5 == 0) {
//					tmp /= 5;
//					continue;
//				}
//				num += 1;
//				tmp = num;
//			}
//			dp[i] = num;
//		}
//		
//		System.out.println(dp[n]);
//	}

}
