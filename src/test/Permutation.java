package test;

import java.util.*;

public class Permutation {
	public static int[] arr = { 1, 2, 3, 4, 5 };
	public static boolean[] visited = new boolean[5];
	public static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println("순열 결과");
		makePermutation(3, new int[3], 0, visited);
	}

	// r : 뽑고자 하는 개수
	// temp : r개를 뽑는 결과값을 저장해놓는 배열
	// current : 현재 개수를 저장해 놓는 값
	// visited : 방문 여부를 확인하는 배열
	private static void makePermutation(int r, int[] temp, int current, boolean[] visited) {
		if (r == current) {
			System.out.println(Arrays.toString(temp));
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					temp[current] = arr[i];
					makePermutation(r, temp, current + 1, visited);
					visited[i] = false;
				}
			}
		}
	}
}
