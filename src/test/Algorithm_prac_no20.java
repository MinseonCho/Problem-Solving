package test;

import java.util.Arrays;
import java.util.Scanner;

//모험가 길드 311p

public class Algorithm_prac_no20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
		}

		int cnt = 0; // 총 그룹의 수

		Arrays.sort(data);

		int t = 1; // 현재 그룹에 포함된 모험가의 수
		for (int i = 0; i < n; i++) {
			if (t >= data[i]) {
				cnt++;
				t = 1;
				continue;
			}
			t++;
		}

		System.out.println("result = " + cnt);
	}

}
