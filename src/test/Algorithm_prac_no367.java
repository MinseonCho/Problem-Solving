package test;

import java.util.*;

// 정렬된 배열에서 특정 수의 개수 구하기
public class Algorithm_prac_no367 {
	public static int n, x;
	public static int[] arr;

//방식 2
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int result = getNumber();
		if (result == 0)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	public static int getStart() {
		int start = 0;
		int end = arr.length;
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] >= x)
				end = mid;
			else
				start = mid + 1;
		}
		return end;
	}

	public static int getEnd() {
		int start = 0;
		int end = arr.length;
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (arr[mid] > x)
				end = mid;
			else
				start = mid + 1;
		}
		return end;
	}

	public static int getNumber() {
		return getEnd() - getStart();
	}

// 방식 1
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		x = sc.nextInt();
//		arr = new int[n];
//
//		for (int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//		}
//		System.out.println(getNumber());
//	}
//
//
//	public static int getNumber() {
//		int mid, result = 0;
//		int left = 0, right = arr.length - 1;
//
//		while (right >= left) {
//			mid = (left + right) / 2;
//
//			if (arr[mid] == x) {
//				int tmp = mid;
//				while (arr[tmp] == x) {
//					result++;
//					tmp++;
//				}
//				tmp = mid - 1;
//				while (arr[tmp] == x) {
//					result++;
//					tmp--;
//				}
//				break;
//			}
//
//			if (arr[mid] > x)
//				right = mid - 1;
//			else
//				left = mid + 1;
//
//		}
//
//		return result == 0 ? -1 : result;
//	}

}
