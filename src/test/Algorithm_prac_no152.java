package test;

import java.awt.Point;
import java.util.*;

public class Algorithm_prac_no152 {

	static int n, m;
	static int[][] graph = new int[200][200];
	static int[] dx = { -1, 1, 0, 0 }; // »óÇÏÁÂ¿ì
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Point> que = new LinkedList<Point>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}

		int x = 0, y = 0;
		que.add(new Point(0, 0));
		while (!que.isEmpty()) {
			Point p = que.poll();
			x = p.x;
			y = p.y;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (graph[nx][ny] == 1) {
					graph[nx][ny] = graph[x][y] + 1;
					que.add(new Point(nx,ny));
				}
			}

		}
		System.out.println(graph[n-1][m-1]);
	}

}
