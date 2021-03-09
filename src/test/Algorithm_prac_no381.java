package test;

import java.util.Scanner;

public class Algorithm_prac_no381 {
	static int n;
	static int[] ugly = new int[1000]; // 못생긴 수를 담기 위한 테이블 (1차원 DP 테이블)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		// 2배, 3배, 5배를 위한 인덱스
		int i2 = 0, i3 = 0, i5 = 0;
		// 처음에 곱셈 값을 초기화
		int next2 = 2, next3 = 3, next5 = 5;

		ugly[0] = 1; // 첫 번째 못생긴 수는 1
		// 1부터 n까지의 못생긴 수들을 찾기
		for (int l = 1; l < n; l++) {
			// 가능한 곱셈 결과 중에서 가장 작은 수를 선택
			ugly[l] = Math.min(next2, Math.min(next3, next5));
			// 인덱스에 따라서 곱셈 결과를 증가
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
		// n번째 못생긴 수를 출력
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
