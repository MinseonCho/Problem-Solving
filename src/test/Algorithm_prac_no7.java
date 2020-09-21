package test;

import java.util.Scanner;

public class Algorithm_prac_no7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int result = 1;
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		int x = sc.nextInt();
		int y = sc.nextInt();

		int way = sc.nextInt(); // 0 : 북 , 1 : 동, 2 : 남, 3 : 서


		// 방향에 해당하는 왼쪽 칸
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 };

		int[] next_way = { 3, 0, 1, 2 };

		int[] back_x = { 1, 0, -1, 0 };
		int[] back_y = { 0, -1, 0, 1 };

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int count = 0;
		while (true) {

			int tx = x + dx[way];
			int ty = y + dy[way];

			//방향의 왼쪽 칸이 방문을 안했고, 육지일 경우
			if (!visited[tx][ty] && map[tx][ty] == 0) {
				visited[tx][ty] = true;
				x = tx;
				y = ty;
				way = next_way[way];
				count = 0;
				result++;
			} else {
				//방향의 왼쪽 칸이 방문을 했거나 바다일 경우
				count++;
				way = next_way[way];
			}

			//한바퀴를 돌았는데 네면이 다 바다거나 방문했을 경우
			if (count == 4) {
				count = 0;
				int tmp_x = back_x[way];
				int tmp_y = back_y[way];
				if (map[tmp_x][tmp_y] == 0) { //뒤에가 육지일 경우
					x += tmp_x;
					y += tmp_y;
				} else //뒤가 바다일 경우
					break;
			}

		}

		System.out.println("result = " + result);
	}

}
