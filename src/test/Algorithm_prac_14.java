package test;

import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_prac_14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 떡 개수
		int M = sc.nextInt(); // 요청한 개수
		int[] data = new int[N];
		for (int n = 0; n < N; n++) {
			data[n] = sc.nextInt();
		}

		Arrays.sort(data);

		if (calculate(data, 0, data[N - 1], M) != -1)
			System.out.println(calculate(data, 0, data[N - 1], M));
		else
			System.out.println("gg");

	}

	static int calculate(int[] data, int start, int end, int target) {
		int mid = (start + end) / 2;

		int sum = 0;

		if (start > end)
			return -1;

		for (int i : data) {
			if (i > mid)
				sum += (i - mid);
		}

		if (sum == target)
			return mid;
		if (sum > target)
			return calculate(data, mid + 1, end, target);
		else
			return calculate(data, start, mid-1, target);

	}

}
