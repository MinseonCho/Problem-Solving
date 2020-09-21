package test;

import java.util.*;

public class SWE_1859 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();
		for (int i = 0; i < cnt; i++) {


			int n = sc.nextInt();
			int[] arr = new int[n];
			long result = 0;
			for (int j = 0; j < n; j++)
				arr[j] = sc.nextInt();
			int max = arr[n - 1];
			for (int j = n - 2; j > -1; j--) {
				if (max < arr[j])
					max = arr[j];
				else
					result += max - arr[j];
			}

			System.out.println("#" + (i + 1) + " " + result);

		}
	}

}
