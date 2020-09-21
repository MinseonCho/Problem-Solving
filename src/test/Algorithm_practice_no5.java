package test;

import java.util.Scanner;

public class Algorithm_practice_no5 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int count = 0;
		
	
		for (int h = 0; h < N + 1; h++) {
			String st1 = Integer.toString(h);

			for (int m = 0; m < 60; m++) {
				String st2 = st1 + m;

				for (int s = 0; s < 60; s++) {
					String st3 = st2 + s;
					if (st3.indexOf('3') != -1)
						count++;
				}
			}
		}

		for (int h = 0; h < N + 1; h++) {
			String st = Integer.toString(h);
			if(st.indexOf('3') != -1) {
				count += 3600;
				continue;
			}
			for (int m = 0; m < 60; m++) {
				st = Integer.toString(m);
				if(st.indexOf('3') != -1) {
					count += 60;
					continue;
				}
				for (int s = 0; s < 60; s++) {
					st = Integer.toString(s);
					if (st.indexOf('3') != -1)
						count++;
				}
			}
		}

		System.out.println("result = " + count );


	}

}
