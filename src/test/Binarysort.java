package test;

import java.util.Arrays;

public class Binarysort {
	static int[] arr = { 34, 56, 2, 14, 77, 84, 23, 11, 5 };

	public static void main(String[] args) {

		Arrays.sort(arr);
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println(" ");
		int start = 0;
		int end = arr.length - 1;
		System.out.println(binary_sorting(start, end, 77) + 1);
	}

	static int binary_sorting(int start, int end, int target) {
		int mid = (start + end) / 2;
		if (arr[mid] == target) {
			return mid;
		} else if (arr[mid] < target) {

			return binary_sorting(mid + 1, end, target);
		} else {
			return binary_sorting(start, mid - 1, target);
		}
	}

}
