package test;

import java.util.*;

public class Algorithm_prac_no182 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] arrA = new int[n];
		Integer[] arrB = new Integer[n];

		for (int i = 0; i < n; i++) {
			arrA[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arrB[i] = sc.nextInt();
		}
		Arrays.sort(arrA);
		Arrays.sort(arrB, Collections.reverseOrder());
		
		int result = 0;
		for (int i = 0; i < k; i++) {
			if (arrB[i] > arrA[i]) {
				int tmp = arrA[i];
				arrA[i] = arrB[i];
				arrB[i] = tmp;
			}
			else
				break;
		}
		for (int i = 0; i < n; i++) {
			result += arrA[i];
		}

		System.out.println(result);
	}

}
