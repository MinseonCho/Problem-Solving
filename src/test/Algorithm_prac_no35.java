package test;

import java.util.*;

// 특정거리의 도시 찾기 339p

public class Algorithm_prac_no35 {

	static int N; // 도시의 개수
	static int M; // 도로의 개수
	static int K; // 거리 정보
	static int X; // 출발 도시의 번호
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int[] result;
	static boolean flag = false;
	static Queue<Integer> que = new LinkedList<Integer>();
	private static final int INF = (int) 1e9;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();

		result = new int[N + 1];
		Arrays.fill(result, INF);

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph.get(x).add(y);
		}

		sc.close();
		que.add(X);
		result[X] = 0;
		bfs();

		for (int i = 1; i < result.length; i++) {
			if (result[i] == K) {
				flag = true;
				System.out.println(i);
			}
		}
		if (!flag)
			System.out.println(-1);
	}

	static void bfs() {

		while (!que.isEmpty()) {
			int pre = que.poll();
			for (int i = 0; i < graph.get(pre).size(); i++) {
				int nextNode = graph.get(pre).get(i);
				if (result[nextNode] == (int) 1e9) {
					que.add(nextNode);
					result[nextNode] = result[pre] + 1; // 현재까지의 최소거리 + 1
				}

			}
		}

	}

}
