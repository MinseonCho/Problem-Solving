package test;

import java.util.*;

public class Algorithm_prac_no9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int x = 0, y = 0;

		int answer = 0;

		Queue<Poin> qu = new LinkedList<>();

		// up, down, left, right
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		int[][] metrix = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				metrix[i][j] = str.charAt(j) - '0';
			}
		}

		qu.add(new Poin(x, y));
		
		while (!qu.isEmpty()) {
			Poin tmp = qu.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];

				if (nx < 0 | nx > N - 1 | ny < 0 | ny > M - 1)
					continue;
				if (metrix[nx][ny] == 0)
					continue;
				if (metrix[nx][ny] == 1) {
					metrix[nx][ny] = metrix[tmp.x][tmp.y] + 1;
					qu.add(new Poin(nx, ny));
				}

			}
		}

		System.out.println("result = " + metrix[N-1][M-1]);

	}

}
