package test;

import java.util.Scanner;

public class Baekjoon_1003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] fi = new int[41];
		int numOfTestCase,testCase;
		numOfTestCase = sc.nextInt();
		fi[0] = 0;
		fi[1] = 1;
		
		for(int i=0; i<numOfTestCase; i++) {
			testCase = sc.nextInt();
			if(testCase == 0) {
				System.out.println(1 + " " + 0);
			}
			else if(testCase == 1)
				System.out.println(0 + " " + 1);
			else {
				fiCal(fi,testCase);
				
			}

		}
		
		sc.close();

	}
	public static int fiCal(int[] fi, int testCase) {
		
		if(testCase == 0 || testCase == 1) {
			return fi[testCase];
		}
		if(fi[testCase] != 0){
			return fi[testCase];
		}
		else {
			fi[testCase] = fiCal(fi,testCase-1) + fiCal(fi,testCase-2);
			return fi[testCase];
		}
	}
	
	
}
