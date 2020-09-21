package test;

import java.util.*;

public class Baekjoon_10809 {

	 static Scanner scan = new Scanner(System.in);
	    static Stack<Character> op = new Stack<Character>();
	    static Stack<Integer> sum = new Stack<Integer>();
	 
	    static int get_priority(char op) {//�켱���� ��ȯ �Լ�
	        int pri = 0;
	        switch (op) {
	        case '+':
	            pri = 0;
	            break;
	        case '*':
	            pri = 1;
	            break;
	        }
	        return pri;
	    }
	 
	    static String convert_to_post(String exp) {// ���� -> ����
	        String post = "";
	        for (int i = 0; i < exp.length(); i++) {
	            char tmp = exp.charAt(i);
	            if (tmp - '0' >= 0 && tmp - '0' < 10)
	                post += tmp;
	            else {
	                while(!op.empty() && get_priority(op.peek())>=get_priority(tmp)) {
	                    //�켱������ *�� �� ũ�� ������ ���ÿ� �ִ� *�� ���� ó�����ֱ� ���� ����
	                    post+=op.pop();
	                }
	                op.push(tmp);
	            }
	        }
	        while (!op.empty())// ���ÿ� �����ִ� ������ ó��
	            post += op.pop();
	        
	        System.out.print(post);
	        return post;
	    }
	 
	    static int calc_post_exp(String exp) {// ������ ���
	        int answer = 0;
	        int n1, n2;
	        for (int i = 0; i < exp.length(); i++) {
	            char tmp = exp.charAt(i);
	            if (tmp - '0' >= 0 && tmp - '0' < 10)
	                sum.push(tmp - '0');
	            else {
	                switch (tmp) {
	                case '+': {
	                    int result = 0;
	                    for (int j = 0; j < 2; j++)
	                        result += sum.pop();
	                    sum.push(result);
	                    break;
	                }
	                case '*': {
	                    int result = 1;
	                    for (int j = 0; j < 2; j++)
	                        result *= sum.pop();
	                    sum.push(result);
	                    break;
	                }
	                }
	            }
	        }
	        answer = sum.pop();
	        return answer;
	    }
	 
	    static void solution() {
	        String str = "";
	        for (int i = 1; i <= 10; i++) {
	            scan.nextInt();
	            str = scan.next();
	            System.out.println("#" + i + " " + calc_post_exp(convert_to_post(str)));
	        }
	    }
	 
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        solution();
	    }

}
