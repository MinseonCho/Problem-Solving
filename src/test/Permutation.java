package test;

import java.util.*;

public class Permutation {
	public static int[] arr = { 1, 2, 3, 4, 5 };
	public static boolean[] visited = new boolean[5];
	public static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println("���� ���");
		makePermutation(3, new int[3], 0, visited);
	}

	// r : �̰��� �ϴ� ����
	// temp : r���� �̴� ������� �����س��� �迭
	// current : ���� ������ ������ ���� ��
	// visited : �湮 ���θ� Ȯ���ϴ� �迭
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
