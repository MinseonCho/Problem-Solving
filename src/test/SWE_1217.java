package test;

import java.util.*;

public class SWE_1217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++) {
			int testCase = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int result = calculate(N, M);
			
			System.out.print("#"+ testCase + " ");
			System.out.print(result +"\n");
		}

	}
	
	static int calculate(int n, int m) {
		if( m == 1) return n;
		else return n * calculate(n, m-1);
	}

}
