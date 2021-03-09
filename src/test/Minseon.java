package test;

import java.util.*;

public class Minseon {

	static int n;
	// »óÇÏÁÂ¿ì
	static int[] xM = { -1, 1, 0, 0 };
	static int[] yM = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		sc.nextLine();
		
		String str = sc.nextLine();
		str = str.replaceAll(" ", "");

		int x = 0, y = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			int tmpx = x;
			int tmpy = y;
			if (ch == 'U') {
				tmpx = x + xM[0];
				tmpy = y + yM[0];
			} else if (ch == 'D') {
				tmpx = x + xM[1];
				tmpy = y + yM[1];
			} else if (ch == 'L') {
				tmpx = x + xM[2];
				tmpy = y + yM[2];
			} else {
				tmpx = x + xM[3];
				tmpy = y + yM[3];
			}

			if (tmpx >= 0 && tmpx < n && tmpy >= 0 && tmpy < n) {
				x = tmpx;
				y = tmpy;
			}
		}

		System.out.println(++x + " " + ++y);
	}

}
