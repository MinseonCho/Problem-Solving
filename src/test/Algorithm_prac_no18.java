package test;

import java.util.*;

//미래 도시 259p

public class Algorithm_prac_no18 {

	public static final int INF = (int) 1e9;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // node 개수
		int m = sc.nextInt(); // edge 개수
		int[][] d = new int[n + 1][n + 1];

		for (int i = 0; i < n + 1; i++) {
			Arrays.fill(d[i], INF);
		}

		for (int a = 0; a < n + 1; a++) {
			for (int b = 0; b < n + 1; b++) {
				if(a == b) {
					d[a][b] = 0;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			d[x][y] = 1;
			d[y][x] = 1;
		}

		int x = sc.nextInt();
		int k = sc.nextInt();

		for (int t = 1; t < n + 1; t++) {
			for (int a = 1; a < n + 1; a++) {
				for (int b = 1; b < n + 1; b++) {
					d[a][b] = Math.min(d[a][b], d[a][t] + d[t][b]);
				}
			}
		}
		if (d[1][k] != INF && d[k][x] != INF) {
			System.out.println(d[1][k] + d[k][x]);
		} else {
			System.out.println(-1);
		}

	}
}
