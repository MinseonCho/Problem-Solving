package test;

import java.util.*;

// 감시피하기
public class Algorithm_prac_no351 {
	private static int n; // 맵 크기
	private static char[][] graph;
	private static ArrayList<Poin> empty = new ArrayList<Poin>(); // 빈공간 좌표 저장
	private static ArrayList<Poin> teacher = new ArrayList<Poin>(); // 선생님 좌표 저장
	private static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dy = { 0, 0, -1, 1 };
	private static boolean result = false;

	// 선생님이 학생을 볼 수 있는지 검사
	// return 1 : 볼 수 있음. return 0 : 볼 수 없음.
	private static int calcul() {
		for (int i = 0; i < teacher.size(); i++) {
			for (int j = 0; j < 4; j++) {
				int nx = teacher.get(i).x + dx[j];
				int ny = teacher.get(i).y + dy[j];
				while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					// 학생을 만나면 볼 수 있음의 의미인 1 return
					if (graph[nx][ny] == 'S')
						return 1;
					// 장애물이나 선생을 만나면 이 방향에서는 학생이 안보이는 걸로 하고 다음 선생님 위치로 넘어감
					else if (graph[nx][ny] == 'O' || graph[nx][ny] == 'T')
						break;
					// 빈공간이면 한칸 더 이동
					nx += dx[j];
					ny += dy[j];
				}
			}
		}
		return 0;
	}

	// 장애물 놓기
	private static void dfs(int cnt, int idx) {
		if (cnt == 3) {
			if (calcul() == 0) // 검사해서 볼 수 없으면
			{
				result = true;
			}
			return;
		}

		for (int i = idx; i < empty.size(); i++) {
			int x = empty.get(i).x;
			int y = empty.get(i).y;
			graph[x][y] = 'O';
			dfs(++cnt, i + 1);
			// 결과가나왔으면
			if (result)
				return;
			cnt--;
			graph[x][y] = 'X';
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		graph = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				char tmp = sc.next().charAt(0);
				graph[i][j] = tmp;
				if (tmp == 'X')
					empty.add(new Poin(i, j));
				else if (tmp == 'T')
					teacher.add(new Poin(i, j));
			}
		}

		dfs(0, 0);
		
		if (result)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
