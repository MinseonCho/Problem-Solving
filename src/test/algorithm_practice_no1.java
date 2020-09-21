package test;

import java.util.*;
import java.util.Scanner;

public class algorithm_practice_no1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("start");
		int result = 0;

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		Integer[] data = new Integer[N];

		for (int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}

		sc.close();

		Arrays.sort(data, Collections.reverseOrder());

		int j = 0;
		
		while (j < M) {
			for(int i =0; i<K; i++) {
				if(j++ >= M) break;
				result += data[0].intValue();
			}
			if(j++ >= M) break;
			result += data[1].intValue();
		}
		System.out.println("result = " + result);

	}

}
