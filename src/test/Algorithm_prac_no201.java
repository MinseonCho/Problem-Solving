package test;

import java.util.*;

public class Algorithm_prac_no201 {
	static int n, m, max = 0;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		binary_sorting(0, arr[n - 1]);
		System.out.println(max);

	}

	static void binary_sorting(int start, int end) {
		if (start > end)
			return;
		int mid = (start + end) / 2;

		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] > mid)
				sum += (arr[i] - mid);
		}
		if (sum >= m) {
			max = Math.max(max, mid);
			binary_sorting(mid + 1, end);
		} else {
			binary_sorting(start, mid - 1);
		}

	}

}
