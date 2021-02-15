package test;

import java.util.*;

public class Algorithm_prac_no341 {

	public static int n, m;
	public static int[][] map;
	public static ArrayList<Poin> data = new ArrayList<Poin>();
	public static ArrayList<Poin> virus = new ArrayList<Poin>();
	public static int result = -1;
	public static int[] dataX = { -1, 1, 0, 0 }; // 상하좌우
	public static int[] dataY = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int num = sc.nextInt();
				map[i][j] = num;
				if (num == 0)
					data.add(new Poin(i, j));
				else if (num == 2)
					virus.add(new Poin(i, j));
			}
		}
		sc.close();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		combination(data.size(), new ArrayList<Integer>(), 3, list);

		for (ArrayList<Integer> arrayList : list) {
			
			for (int i = 0; i < 3; i++) {
				int x = data.get(arrayList.get(i)).x;
				int y = data.get(arrayList.get(i)).y;
				map[x][y] = 1;
			}
			// 바이러스 퍼뜨리기

			for (Poin point : virus) {
				dfs(point.x, point.y);
			}
			// 개수세기

			int tmp = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 0)
						tmp++;
				}
			}

			if (result < tmp) {
				System.out.println(arrayList);
				result = tmp;
			}

			// 되돌리기
			backTo();
			
			for (int i = 0; i < 3; i++) {
				int x = data.get(arrayList.get(i)).x;
				int y = data.get(arrayList.get(i)).y;
				map[x][y] = 0;
			}
		}
		
		System.out.println(result);

	}

	static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nX = dataX[i] + x;
			int nY = dataY[i] + y;
			if (nX < n && nX >= 0 && nY < m && nY >= 0) {
				if (map[nX][nY] == 0) {
					map[nX][nY] = 2;
					dfs(nX, nY);
				} else {
					continue;
				}
			}
		}
	}

	static void backTo() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 2)
					map[i][j] = 0;
			}
		}
		for(Poin point : virus) {
			map[point.x][point.y] = 2;
		}
	}

	// 백트래킹 사용
	// 사용 예시 : combination(arr, visited, 0, n, r)
	static void combination(int n, ArrayList<Integer> picked, int r, ArrayList<ArrayList<Integer>> collection) {
		if (r == 0) {
			collection.add(picked);
			return;
		}
		int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() - 1) + 1;

		for (int i = smallest; i < n; i++) {
			picked.add(i);
			combination(n, new ArrayList<Integer>(picked), r - 1, collection);
			picked.remove(picked.size() - 1);
		}
	}

}
