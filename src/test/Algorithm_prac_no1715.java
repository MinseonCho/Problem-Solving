package test;

import java.util.*;

public class Algorithm_prac_no1715 {
	public static int n;

	public static void main(String[] args) {
		PriorityQueue<Integer> que = new PriorityQueue<>();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			que.add(sc.nextInt());
		}
		int result = 0;
		while (que.size() > 1) {
			int n1 = que.poll();
			int n2 = que.poll();
			result += n1 + n2;
			que.add(n1 + n2);
		}

		System.out.println(result);
	}
//	public static int n, result = (int) 1e9;
//	public static int[] data;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		data = new int[n];
//		for (int i = 0; i < n; i++) {
//			data[i] = sc.nextInt();
//		}
//
//		Arrays.sort(data);
//		combination(n, new ArrayList<Integer>(), n);
//
//		System.out.println(result);
//	}
//
//	// 백트래킹 사용
//	// 사용 예시 : combination(arr, visited, 0, n, r)
//	static void combination(int n, ArrayList<Integer> picked, int r) {
//		if (r == 0) {
//			int sum = data[picked.get(0)] + data[picked.get(1)];
//			for (int i = 2; i < n; i++) {
//				sum += (sum + data[picked.get(i)]);
//			}
//			if(result > sum) result = sum;
//			return;
//		}
//		int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() - 1) + 1;
//
//		for (int i = smallest; i < n; i++) {
//			picked.add(i);
//			combination(n, new ArrayList<Integer>(picked), r - 1);
//			picked.remove(picked.size() - 1);
//		}
//	}

}
