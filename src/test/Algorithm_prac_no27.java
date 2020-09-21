package test;

import java.util.*;

// 문자열 재정렬 322p

public class Algorithm_prac_no27 {
	private static String s;
	private static ArrayList<Character> data = new ArrayList<>();
	private static int num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.next();
		num = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < 58 && s.charAt(i) > 46) {
				// 0~9 일 경우
				num += s.charAt(i) - '0';
			} else {
				// 알파벳 대문자일 경우
				data.add(s.charAt(i));
			}
		}

		Collections.sort(data);
		String result = "";
		for (int i = 0; i < data.size(); i++) {
			result += data.get(i);
		}
		
		result += num;

		System.out.println(result);
	}

}
