package test;

import java.util.*;

class Virus implements Comparable<Virus> {
	int x, y;
	private int num;

	public Virus(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	@Override
	public int compareTo(Virus o) {
		if (this.num < o.getNum())
			return -1;
		else if (this.num == o.getNum())
			return 0;
		else
			return 1;
	}
}

public class Algorithm_prac_no344 {

	public static int n, k, s, x, y; // s초 뒤에 (x,y)에 존재하는 바이러스 종류 출력
	public static int[][] graph;
	public static ArrayList<Virus> virus = new ArrayList<>();
	public static int[] dirX = { -1, 1, 0, 0 }; // 상하좌우
	public static int[] dirY = { 0, 0, -1, 1 };
	public static Queue<Virus> list = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt(); // 바이러스 종류 1~k
		graph = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				int tmp = sc.nextInt();
				graph[i][j] = tmp;
				if (tmp != 0)
					virus.add(new Virus(i, j, tmp));
			}
		}

		Collections.sort(virus);
		for (int i = 0; i < virus.size(); i++) {
			list.add(virus.get(i));
		}
		virus.clear();
		s = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();

//		list.add(virus.get(0));
		for (int i = 1; i <= s; i++) {
			while (!list.isEmpty()) {
				Virus now = list.poll();

				for (int j = 0; j < 4; j++) {
					int nx = now.x + dirX[j];
					int ny = now.y + dirY[j];
					if (nx >= 0 && nx < n + 1 && ny >= 0 && ny < n + 1 && graph[nx][ny] == 0) {
						graph[nx][ny] = now.getNum();
						virus.add(new Virus(nx, ny, now.getNum()));
					}
				}
			}
			for (int k = 0; k < virus.size(); k++) {
				list.add(virus.get(k));
			}
			virus.clear();
		}

		System.out.println("answer = " + graph[x][y]);
	}

}
