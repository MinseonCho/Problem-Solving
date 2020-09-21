package test;

import java.util.*;

public class Algorithm_practice_no4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int x = 1, y = 1;
		sc.nextLine();
		String oper = sc.nextLine();
		String[] st = oper.split(" ");

		String[] move_types = { "L", "R", "U", "D" };
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };

		for (String i : st) {
			for (int j = 0; j < move_types.length; j++) {
				if (i.equals(move_types[j]) ) {

					int nx = x + dx[j];
					int ny = y + dy[j];

					if (nx > N | nx < 1 | ny > N | ny < 1)
						break;
					x = nx;
					y = ny;
				}
			}

		}

		System.out.println("result = " + x + " " + y);
	}

}
