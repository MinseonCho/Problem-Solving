package test;

import java.util.*;

public class Algorithm_prac_no197 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[100001];
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			arr[num]++;
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int tmp = sc.nextInt();
			if (arr[tmp] != 0)
				System.out.print("yes" + " ");
			else
				System.out.print("no" + " ");
		}

	}

}
