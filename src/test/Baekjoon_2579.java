package test;

import java.util.Scanner;

public class Baekjoon_2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stairN;
		int[] score;
		int[] resultSc;

		stairN = sc.nextInt();
		score = new int[stairN+1];
		resultSc = new int[stairN+1];
		
		for(int i=1; i<stairN+1; i++) {
			score[i] = sc.nextInt();
		}
		
		sc.close();
		
		
		resultSc[1] = score[1];
		if(stairN >= 2) resultSc[2] = resultSc[1] + score[2];
		
		for(int i=3; i<stairN+1; i++) {
			resultSc[i] = Math.max(resultSc[i-2] + score[i], resultSc[i-3] + score[i-1] + score[i]);
		}
		
		
		System.out.println(resultSc[stairN]);
	}

}
