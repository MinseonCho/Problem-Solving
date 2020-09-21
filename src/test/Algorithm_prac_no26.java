package test;

import java.util.Scanner;

//럭키 스트레이트 321p

public class Algorithm_prac_no26 {

	private static String s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.next();
		int idx = s.length() / 2;
		String s1 = s.substring(0, idx);
		String s2 = s.substring(idx);

		int num1 = 0, num2 = 0;
		for (int i = 0; i < s1.length(); i++) {
			num1 += s1.charAt(i) - '0';
			num2 += s2.charAt(i) - '0';
		}
		
		if(num1 == num2) 
			System.out.println("LUCKY");
		else
			System.out.println("READY");
	}

}
