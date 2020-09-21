package test;

import java.util.Scanner;

//무지의 먹방 라이브 316p

public class Algorithm_prac_no25 {

	public static int solution(int[] food_times, long k) {
		int answer = 0;
		int i = 0;
		while (i <= k) {
			for (int j = 0; j < food_times.length; j++) {
				if (food_times[j] > 0) {
					food_times[j] -= 1;
					answer = j + 1;
					i++;
					continue;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] food_times = new int[n];
		for (int i = 0; i < n; i++) {
			food_times[i] = sc.nextInt();
		}

		int k = sc.nextInt();
		System.out.println(solution(food_times, k));
	}

}
