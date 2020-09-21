package test;

import java.util.Scanner;

//볼링공 고르기 315p

public class Algorithm_prac_no24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int max = sc.nextInt();
		String s = "";
		for (int i = 0; i < n; i++)
			s += sc.nextInt();

		

		int result = 0;
		for (int i = 0; i < n; i++) {
			String tmp = s;
			char c = tmp.charAt(i);
			tmp = tmp.substring(i + 1);
			while (!tmp.isEmpty()) {
				int inx = tmp.indexOf(c);
				if (inx != -1) {
					result += inx;
					if (inx + 1 <= tmp.length() - 1)
						tmp = tmp.substring(inx + 1);
					else
						break;
				} else {
					result += tmp.length();
					break;
				}
			}
		}
		
		System.out.println("result = " + result);
	}

}
