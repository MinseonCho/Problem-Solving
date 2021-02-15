package test;

import java.util.*;
import java.util.Scanner;

public class Algorithm_prac_no369 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			arr[i] = tmp;
		}
		Arrays.sort(arr);
		int start = arr[0];
		int end = arr[n - 1];
		int mid ;
		list.add(start);
		list.add(end);
		n -= 2;
		while (n > 0) {
			mid = (start + end) / 2;
			if(arr[mid])
		}

	}

}
