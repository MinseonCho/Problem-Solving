package test;

import java.util.Scanner;

public class Algorithm_practice_no3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int count = 0;

		do {
			if (N % K == 0) {
				N /= K;
				count++;
			} else {
				int tmp = N % K;
				N -= (tmp);
				count += (tmp);
			}
		} while (N > K);

		if (N > 1) {
			count++;
			N -= 1;
		}

		System.out.println("result = " + count);

	}

}
