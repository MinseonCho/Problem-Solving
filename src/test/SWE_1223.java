package test;

import java.util.*;

public class SWE_1223 {

	public static void main(String[] args) {
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
				if(tmp == '*') {
					if(!cal.isEmpty()) {
						char m = cal.peek();
						
						if( m == '+') 
							cal.push(tmp);
						else if(m == '*') {
							while(!cal.isEmpty()&& cal.peek().equals('*')) {
								result.add(cal.pop());
							}
							cal.push(tmp);
						}
					}else {
						//when cal is empty
						cal.push(tmp);
					}
				}else if(tmp == '+') {
						while(!cal.isEmpty()) {
							char m = cal.peek();
							if(m == '+' || m == '*') {
								result.add(cal.pop());
							}
						}
						cal.push(tmp);
				}else {
					//number
					result.add(tmp);
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
//							System.out.println("oper_2  = " + oper_2);
							int oper_1 = results.pop();
//							System.out.println("oper_1  = " + oper_1);
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

}
