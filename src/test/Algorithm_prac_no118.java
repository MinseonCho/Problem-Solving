package test;

import java.util.*;

public class Algorithm_prac_no118 {

	static int n, m;
	static int x, y, d;
	static int[] dir = { 0, 1, 2, 3 }; // ºÏµ¿³²¼­
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;

	static int result = 0;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		d = sc.nextInt();

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		map[x][y] = 1;
		result++;
		while (true) {
			d -= 1;
			if (d < 0)
				d = 3;

			int nx = x + dx[d];
			int ny = y + dy[d];

			if (map[nx][ny] == 0) {
				result++;
				x = nx;
				y = ny;
				map[x][y] = 2;
				cnt = 0;
			}
			cnt++;

			if (cnt == 4) {

				nx = x - dx[d];
				ny = y - dy[d];

				if (map[nx][ny] == 1)
					break;

				x = nx;
				y = ny;

			}

		}
		System.out.println(result);
	}

}
