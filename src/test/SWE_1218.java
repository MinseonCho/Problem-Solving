package test;

import java.util.*;

public class SWE_1218 {
	static Stack<Character> stack;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int answer = 0;

		for( int i=1; i<=10; i++) {
			stack = new Stack<>();
			int len = sc.nextInt();
			sc.nextLine();
			String rowInput = sc.next();
            for(int j=0; j<len; j++) { 
            	char tmp = rowInput.charAt(j);
            	if(tmp == '{' || tmp == '(' || tmp == '[' || tmp == '<' ) {
            		stack.push(tmp);
            	}else {
            		int res = cal(tmp);
            		if(res == 0) {
            			answer = 0;
            			break;
            		}
            	}
            	
            		
            }
            if( stack.isEmpty()) {
            	answer = 1;
            	System.out.print("#" + i + " " + answer +"\n");
            }else
            	System.out.print("#" + i + " " + answer+"\n");
		}
	}
	
	static int cal(char ch) {
		char cmp = 0;
		if( ch == '}') cmp = '{';
		else if( ch == '>') cmp = '<';
		else if( ch == ']') cmp = '[';
		else if( ch == ')') cmp = '(';
		
		int size = stack.size();
		for(int r =0; r<stack.size(); r++) {
			char tp = stack.pop();
			if( tp == cmp) break;
			else{
				stack.push(tp);
			}
		}
		if(size == stack.size()) return 0;
		else return 1;
	}

}
