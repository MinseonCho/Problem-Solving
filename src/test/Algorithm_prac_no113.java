package test;

import java.util.*;

public class Algorithm_prac_no113 {

	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int cnt = 0;

		for (int i = 0; i <= n; i++) {
			String h = Integer.toString(i);
			for (int j = 0; j < 60; j++) {
				String m = Integer.toString(j);
				for (int z = 0; z < 60; z++) {
					String s = Integer.toString(z);
					// if (h.contains("3") | m.contains("3") | s.contains("3"))
					String str = h + m + s;
					if (str.contains("3"))
						cnt++;
				}
			}
		}

		System.out.println(cnt);


	}

}
