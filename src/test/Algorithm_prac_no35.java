package test;

import java.util.*;

// Ư���Ÿ��� ���� ã�� 339p

public class Algorithm_prac_no35 {

	static int N; // ������ ����
	static int M; // ������ ����
	static int K; // �Ÿ� ����
	static int X; // ��� ������ ��ȣ
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
					result[nextNode] = result[pre] + 1; // ��������� �ּҰŸ� + 1
				}

			}
		}

	}

}
