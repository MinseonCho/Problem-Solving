package test;

import java.util.Scanner;

public class Algorithm_prac_no6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String loc = sc.next();
		String tmp = "0abcdefgh";
		int x = tmp.indexOf(loc.charAt(0));
		int y = loc.charAt(1) - '0';
		
		System.out.println("x = " + x + " y = " + y);

		int[] dx = { -1, 1, -1, 1, -2, -2, 2, 2 };
		int[] dy = { -2, -2, 2, 2, -1, 1, -1, 1 };

		int count = 0;

		for (int i = 0; i < dx.length; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if (tx > 8 | ty > 8 | tx < 1 | ty < 1)
				continue;
			count++;
		}

		System.out.println("result = " + count);
	}

}
