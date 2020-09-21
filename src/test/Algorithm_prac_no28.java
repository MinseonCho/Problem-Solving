package test;

import java.util.*;

// 문자열 압축 323p

public class Algorithm_prac_no28 {

	private static String s;
	private static int results;

	private static int compress(String s) {
		int half = s.length() / 2;
		results = s.length();
		String news = "";

		for (int i = 1; i < half + 1; i++) {
			int cnt = 1; // 동일한 문자열이 나왔을 경우 ++
			String compressed = "";
			String prev = s.substring(0, i);

			// 단위만큼 증가시키며 이전 문자열과 비교
			for (int j = i; j < s.length(); j += i) {
				String sub = "";
				for (int k = j; k < j + i; k++) {
					if (k < s.length())
						sub += s.charAt(k);
				}

				if (prev.equals(sub))
					cnt++;
				else {
					compressed += (cnt > 1) ? cnt + prev : prev;
					sub = "";
					for (int k = j; k < j + i; k++) {
						if (k < s.length())
							sub += s.charAt(k);
					}
					prev = sub;
					cnt = 1;
				}
			}

			compressed += (cnt > 1) ? cnt + prev : prev;
			results = Math.min(results, compressed.length());
		}


		return results;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		s = sc.next();

		System.out.println(compress(s));
	}

}
