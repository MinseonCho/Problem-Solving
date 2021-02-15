package test;

import java.util.Arrays;

public class BinarySearch {
	public static int[] data = { 4, 6, 3, 2, 7, 5, 8, 5 };

	public static void main(String[] args) {
		int n = 2; // 7Ã£±â
		System.out.println(binery(n, data));
	}
	public static boolean binery(int key, int[] arr) {
		Arrays.sort(arr);
		int mid;
		int left = 0, right = arr.length - 1;

		while (right >= left) {
			mid = (left + right) / 2;
			if (arr[mid] == key)
				return true;
			if (arr[mid] > key)
				right = mid - 1;
			else
				left = mid + 1;
		}

		return false;
	}
}
