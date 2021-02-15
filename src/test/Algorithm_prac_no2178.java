package test;

import java.util.*;
// น้มุ 2178
public class Algorithm_prac_no2178 {
	public static int n, m;
	public static int[][] matrix;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };
	public static Queue<Poin> que = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		matrix = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				matrix[i][j + 1] = str.charAt(j) - '0';
			}
		}
	
		System.out.println(bfs());
	}

	public static int bfs() {
		que.add(new Poin(1, 1));
		while (!que.isEmpty()) {
			Poin now = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx >= 0 && nx <= n && ny >= 0 && ny <= m && matrix[nx][ny] == 1) {
					if (matrix[nx][ny] > 1 && matrix[nx][ny] < matrix[now.x][now.y] + 1)
						continue;
					matrix[nx][ny] = matrix[now.x][now.y] + 1;
					que.add(new Poin(nx, ny));
				}
			}

		}

		return matrix[n][m];
	}

}
