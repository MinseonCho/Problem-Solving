package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//만들 수 없는 금액 314p

public class Algorithm_prac_no23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Integer[] coins = new Integer[n];
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}

		Arrays.sort(coins, Collections.reverseOrder());
		int goal = 1;
		while (true) {
			int tmp = goal;
			for (int i : coins) {
				if (i <= tmp)
					tmp -= i;
			}
			if (tmp > 0)
				break;
			goal++;
		}
		
		System.out.println("result = " + goal);

	}

}
