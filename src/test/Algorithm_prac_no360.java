package test;

import java.util.*;

public class Algorithm_prac_no360 {

	public static int n, result;
	public static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			list.add(tmp);

		}
		Collections.sort(list);
		System.out.println(list.get((n - 1) / 2));

	}
}
