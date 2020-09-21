package test;

import java.util.*;

// 뱀 327p
class Snake {
	int sec;
	char direction;

	public Snake(int sec, char direction) {
		this.sec = sec;
		this.direction = direction;
	}
}

public class Algorithm_prac_no31 {

	private static int[][] matrix;
	private static ArrayList<Snake> direction = new ArrayList<>();
	private static ArrayList<Poin> snake = new ArrayList<>();
	private static int[] x_ = { -1, 0, 1, 0 }; // 북(0), 동(1), 서(2) , 남(3)
	private static int[] y_ = { 0, 1, 0, -1 };
	private static int dir = 1; // 처음에 동쪽을 바라보고 있음
	private static int answer = 0; // 흘러가는 초
	private static int x = 1, y = 1; // 뱀의 시작과 끝

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 보드의 크기
		matrix = new int[n + 1][n + 1];

		int k = sc.nextInt(); // 사과 개수
		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			matrix[x][y] = -1; // 사과 위치 시킴
		}

		int l = sc.nextInt(); // 뱀의 방향 변환 횟수
		for (int i = 0; i < l; i++) {
			int s = sc.nextInt();
			char d = sc.next().charAt(0);
			direction.add(new Snake(s, d));
		}
		matrix[x][y] = 1; // 뱀 초기 위치 설정
		snake.add(new Poin(x, y));

		while (true) {
			// 방향대로 한칸 움직임
			int tmp_x = x + x_[dir];
			int tmp_y = y + y_[dir];

			// 움직인게 벽이 아니라면
			if (tmp_x <= n && tmp_x > 0 && tmp_y <= n && tmp_y > 0 && matrix[tmp_x][tmp_y] != 1) {
				x = tmp_x;
				y = tmp_y;
				snake.add(new Poin(x, y));
				// 위치한 곳에 사과가 있다면
				if (matrix[x][y] == -1) {
					matrix[x][y] = 1;
				} else {
					matrix[x][y] = 1;
					matrix[snake.get(0).x][snake.get(0).y] = 0;
					snake.remove(0);

				}

			} else {
				// 종료
				answer++;
				break;
			}
			// 해당 초에 방향을 바꿔야하는지 검사
			answer++;
			if (!direction.isEmpty() && answer == direction.get(0).sec) {
				if (direction.get(0).direction == 'D') { // 오른쪽으로 방향 회전
					dir++;
					if (dir > 3)
						dir = 0;
				} else { // 왼쪽으로 방향 회전
					dir--;
					if (dir < 0)
						dir = 3;
				}
				direction.remove(0);
			}
		}

		System.out.println(answer);

	}

}
