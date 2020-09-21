package test;

import java.util.Scanner;

public class Algorithm_prac_no15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 3 <= N <= 100

		int[] ware = new int[N];
		int max = 0;
		int[] result = new int[N];

		for (int i = 0; i < N; i++) {
			ware[i] = sc.nextInt();
		}
		
		result[0] = ware[0];
		result[1] = Math.max(ware[0], ware[1]);
		
		
		for (int i = 2; i < N; i++)
			result[i] = Math.max(result[i - 2] + ware[i], result[i - 1]);

		System.out.println("result = " + result[N-1]);
	}

}
