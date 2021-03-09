package test;

import java.util.*;

public class Algorithm_prac_no149 {
	static int n, m;
	static int[][] map = new int[1000][1000];
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < m; j++) {
				System.out.print(map[i][j] + " ");
				
			}
			System.out.println(" ");
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dfs(i, j))
					result++;
			}
		}
		System.out.println(result);
	}

	static boolean dfs(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		if (map[x][y] == 0) {
			map[x][y] = 1; // 방문처리
			dfs(x - 1, y);
			dfs(x + 1, y);
			dfs(x, y - 1);
			dfs(x, y + 1);
			
			return true;
		}

		return false;
	}

}
