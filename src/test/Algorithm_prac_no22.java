package test;

import java.util.Scanner;

//문자열 뒤집기 312p
public class Algorithm_prac_no22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int[] result = new int[2];

		while (!s.isEmpty()) {
			int x = s.indexOf('0');
			int y = s.indexOf('1');

			if (x == -1) {
				result[1]++;
				break;
			}
			if (y == -1) {
				result[0]++;
				break;
			}
			if (x < y) {
				result[0]++;
				s = s.substring(y);
			} else {
				result[1]++;
				s = s.substring(x);
			}

		}

		System.out.println(Math.min(result[0], result[1]));
	}

}
