package test;

import java.util.Scanner;

public class Algorithm_prac_no34 {

	public static int solution(int n, int[] weak, int[] dist) {
		int answer = 0;
		int[] data = new int[n];
		for (int num : weak)
			data[num] = 1; // 약한 부분 -1

		// 한 명이 검사, 두 명이 검사 .... dist.length명이 검사까지
		for (int i = 1; i <= dist.length; i++) {
			for (int j = 0; j + i <= dist.length; j++) {
				for (int start : weak) { // 시작점 다르게
					int tmp = dist[j];
					while (tmp > 0) {

						if (data[start] == -1) {
							data[start] = 0;
						}
						if (!data.toString().contains("-1")) {
							answer = i;
							break;
						}
						start++;
						tmp--;
						if (start >= n)
							start = 0; // 끝까지 가면 다시 인덱스 0으로
					}
					if (answer != 0)
						break;
				}
				if (answer != 0)
					break;
			}
			data = new int[n];
			for (int num : weak)
				data[num] = 1;
			if (answer != 0)
				break;
		}

		return answer; // 취약 지점을 점검하기 위해 보내야 하는 친구 수의 최솟값
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 외벽의 길이
		int[] weak = { 1, 5, 6, 10 }; // 취약 지점의 위치
		int[] dist = { 1, 2, 3, 4 }; // 각 친구가 1시간 동안 이동할 수 있는 거리

		System.out.println(solution(n, weak, dist));

	}

}
