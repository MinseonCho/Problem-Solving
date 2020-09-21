package test;

import java.util.*;

// 전보 262p

public class Algorithm_prac_no19 {
	
	private static final int INF = (int) 1e9;
	private static ArrayList<ArrayList<Node>> d = new ArrayList<ArrayList<Node>>();
	private static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	private static int[] result;

	private static void dij(int start) {
		pq.offer(new Node(start, 0));
		result[start] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			int now = node.getIndex(); //현재 노드
			int value = node.getDistance(); //현재 노드가지의 비용
			
			if(result[now] < value) continue;
			for (int i = 0; i < d.get(now).size(); i++) { //현재 노드에 연결된 노드 수만큼
				int cost = result[now] + d.get(now).get(i).getDistance();
				if(cost < result[d.get(now).get(i).getIndex()]) {
					result[d.get(now).get(i).getIndex()] = cost;
					pq.offer(new Node(d.get(now).get(i).getIndex(), cost));
				}
			}
			
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int e = sc.nextInt();
		int start = sc.nextInt();
		result = new int[n + 1];

		Arrays.fill(result, INF);

		for (int i = 0; i < n + 1; i++) {
			d.add(new ArrayList<Node>());
		}

		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			d.get(a).add(new Node(b, c));
		}

		dij(start);
		
		int cnt = 0, distance = 0;
		for (int i = 1; i < result.length; i++) {
			if (result[i] != INF && result[i] > 0) {
				cnt++;
			}
			if (result[i] > distance)
				distance = result[i];
		}

		System.out.println(cnt + " " + distance);
	}

}
