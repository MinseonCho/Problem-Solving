package test;

import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_prac_no13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[] target = new int[M];
		for (int i = 0; i < M; i++) {
			target[i] = sc.nextInt();
		}

		Arrays.sort(list); // 정렬

		for (int i = 0; i < M; i++) {
			if (calculate(list, target[i], 0, N - 1))
				System.out.print("yes" + " ");
			else
				System.out.print("no" + " ");
		}

	}

	static boolean calculate(int[] list, int target, int start, int end) {
		int mid = (start + end) / 2;

		if (start > end)
			return false;

		if (list[mid] == target)
			return true;

		if (list[mid] > target) { // 왼쪽 검색
			return calculate(list, target, start, mid - 1);
		} else {
			return calculate(list, target, mid + 1, end);
		}

	}

}
