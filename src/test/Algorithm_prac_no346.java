package test;

import java.util.*;

public class Algorithm_prac_no346 {
	public static String str;
	public static Stack<Character> stk = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();

		System.err.println(calcul(str));

	}

	static String calcul(String st) {
		String u = "", v = "";

		if (st == "") {
			return st;
		}
		if (check(st)) {
			return st;
		}

		// u,v찾기
		for (int i = 0; i < str.length(); i++) {
			char c = st.charAt(i);
			if (stk.isEmpty())
				stk.add(c);
			else if (stk.peek() == c)
				stk.add(c);
			else {
				if (!stk.isEmpty()) {
					stk.pop();
					if (stk.isEmpty()) { // u,v 문자열 구하기
						u = st.substring(0, i + 1);
						v = st.substring(i + 1);
						break;
					}
				}
			}
		}

		if (check(u)) {
			v = calcul(v);
			return u + v;
		} else {
			String alter = "(";
			alter += calcul(v) + ")";
			u = u.substring(1, u.length() - 1);
			for (int i = 0; i < u.length(); i++) {
				char tmp = u.charAt(i);
				if (tmp == '(')
					alter += ')';
				else
					alter += '(';
			}

			u = alter;
		}

		return u;
	}

	static boolean check(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(')
				stk.add(c);
			else {
				if (!stk.isEmpty()) {
					stk.pop();
				} else
					return false;
			}
		}
		if (stk.isEmpty())
			return true;
		else
			return false;

	}

}
