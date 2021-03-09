package test;

import java.util.*;

public class Algorithm_prac_no110 {

	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();

		String[] arr = sc.nextLine().split(" ");

		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		char[] move = { 'U', 'D', 'L', 'R' };
		int x = 0, y = 0;
		for (int i = 0; i < arr.length; i++) {
			int nx = x;
			int ny = y;
			char plan = arr[i].charAt(0);
			for (int j = 0; j < move.length; j++) {
				if (move[j] == plan) {
					nx += dx[j];
					ny += dy[j];
					break;
				}
			}
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				x = nx;
				y = ny;
			}
		}

		System.out.println(++x + " " + ++y);
	}

}
