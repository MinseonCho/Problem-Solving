package test;

import java.util.*;

public class Algorithm_prac_no368 {
	public static int binarySearch(int[] arr, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == mid)
				return mid;
			if (arr[mid] > mid)
				end = mid - 1;
			else if (arr[mid] < mid)
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(binarySearch(arr, 0, arr.length - 1));
	}
}
