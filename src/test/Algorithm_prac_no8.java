package test;

import java.util.*;

public class Algorithm_prac_no8 {

	static int N;
	static int M;
	static int[][] data;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		int result = 0;

		data = new int[N][M];

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				data[n][m] = sc.nextInt();
			}
		}

		sc.close();

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (dfs(n, m))
					result++;
			}
		}
		
		System.out.println("result : " + result);

	}

	static boolean dfs(int x, int y) {
		if (x < 0 | x > N - 1 | y < 0 | y > M - 1) {
			return false;
		}
		if (data[x][y] == 0) {
			data[x][y] = 1; // 방문처리
			dfs(x - 1, y); // up
			dfs(x + 1, y); // down
			dfs(x, y - 1); // left
			dfs(x, y + 1); // right
			return true;
		}
		return false;
	}

}
