package test;

import java.util.*;

public class Algorithm_prac_no115 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int x = str.charAt(0) - 'a' + 1;
		int y = str.charAt(1) - '0';

		int[] dx = { -1, 1, -1, 1, -2, -2, 2, 2 };
		int[] dy = { -2, -2, 2, 2, -1, 1, -1, 1 };

		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx > 0 && nx <= 8 && ny > 0 && ny <= 8)
				cnt++;

		}

		System.out.println(cnt);

	}

}
