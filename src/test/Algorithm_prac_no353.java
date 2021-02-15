package test;

import java.util.*;

// 인구 이동
public class Algorithm_prac_no353 {

	public static int n, l, r;
	public static int[][] graph;
	public static boolean[][] visited;
	public static ArrayList<ArrayList<Poin>> comb = new ArrayList<>();
	public static Queue<Poin> que = new LinkedList<>();
	private static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dy = { 0, 0, -1, 1 };
	public static int result = 0;

	public static boolean openBolder() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;
				que.add(new Poin(i, j));
				ArrayList<Poin> tmp = new ArrayList<>();
				tmp.add(new Poin(i, j));
				while (!que.isEmpty()) {
					Poin now = que.poll();
					for (int k = 0; k < 4; k++) {
						int nx = now.x + dx[k];
						int ny = now.y + dy[k];
						if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
							int diff = Math.abs(graph[now.x][now.y] - graph[nx][ny]);
							if (diff >= l && diff <= r) {
								que.add(new Poin(nx, ny));
								visited[i][j] = true;
								visited[nx][ny] = true;
								tmp.add(new Poin(nx,ny));
							}
						}
					}
				}
				if (tmp.size() > 1)
					comb.add(tmp);

			}
		}
		if (comb.size() > 0)
			return true; // 국경선이 열린 나라가 있으면
		else
			return false; // 없으면

	}

	public static void move() {
		result++; // 인구 이동 횟수 증가
		for (int i = 0; i < comb.size(); i++) {
			int sum = 0;
			// 인구 이동 평균값 계산
			for (int j = 0; j < comb.get(i).size(); j++) {
				Poin now = comb.get(i).get(j);
				sum += graph[now.x][now.y];
			}
			int avg = sum / comb.get(i).size();
			// 인구수 적용
			for (int j = 0; j < comb.get(i).size(); j++) {
				Poin now = comb.get(i).get(j);
				graph[now.x][now.y] = avg;
			}
		}

		comb.clear();
		que.clear();
		visited = new boolean[n][n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		l = sc.nextInt();
		r = sc.nextInt();

		graph = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		while (openBolder())
			move();

		System.out.println(result);

	}

}
