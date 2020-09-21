package test;

import java.util.*;

public class Algorithm_practice_no2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // За
		int M = sc.nextInt(); // ї­

		int[][] data = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				data[i][j] = sc.nextInt();
			}
			Arrays.sort(data[i]);
		}

		int max = data[0][0];
		for (int i = 1; i < N; i++) {
			if(max < data[i][0]) max = data[i][0];
		}
		sc.close();

		System.out.println("result = " +max);
	}

}
