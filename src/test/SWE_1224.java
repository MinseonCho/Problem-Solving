package test;

import java.util.*;


public class SWE_1224 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Character> result = new ArrayList<Character>();
		Stack<Character> cal = new Stack<Character>();
		Stack<Integer> results = new Stack<Integer>();
		
		for(int i=1; i<=10; i++) {
			result.clear();
			cal.clear();
			
			int len = sc.nextInt();
			sc.nextLine();
		
			String str= sc.next();
			for(int j =0; j<str.length(); j++) {
				char tmp = str.charAt(j);
				
				if(cal.isEmpty())
					cal.add(tmp);
				else {
					if( tmp -'0' > 0 && tmp -'0' < 10)
						result.add(tmp);
					else if(tmp == ')'){ //')' 일 경우
						while(!cal.isEmpty() && cal.peek() != '(') {
							result.add(cal.pop());
						}
						cal.pop(); //'('제거
					}
					else if(out(tmp) >= in(cal.peek())) {
						while(!cal.isEmpty() && out(tmp) >= in(cal.peek()))
							result.add(cal.pop());
						cal.add(tmp);
					}else {
						cal.add(tmp);
					}
				}
			}
			while(!cal.isEmpty()) {
				result.add(cal.pop());
			}
			cal.clear();
			
			for (int k = 0; k < result.size(); k++) {
	            char tmp = result.get(k);
	            if (tmp != '*' && tmp != '+')
	            	results.push(tmp - '0');
	            else {
	            	if(tmp == '*' || tmp == '+') {
						int oper_2 = results.pop();
						int oper_1 = results.pop();

						int re = 0;
						if(tmp == '*') {
							re = oper_1 * oper_2;
						}else re = oper_1 + oper_2;
						results.push(re);
					}
	            }
	        }

			int rre = results.pop();
			System.out.println("#" + i + " " + rre);
		}

	}
	
	public static int in(char tmp) {
		if(tmp == '*')
			return 1;
		else if(tmp == '+')
			return 2;
		else if(tmp == '(')
			return 4;
		return -1;
	}
	
	public static int out(char tmp) {
		if(tmp == '*')
			return 1;
		else if(tmp == '+')
			return 2;
		else if(tmp == '(')
			return 0;
		return -1;
	}
}


