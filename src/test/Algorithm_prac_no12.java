package test;

import java.util.Arrays;
import java.util.Scanner;

public class Algorithm_prac_no12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] data1 = new int[N];
		int[] data2 = new int[N];

		int sum = 0;

		for (int j = 0; j < N; j++)
			data1[j] = sc.nextInt();
		for (int j = 0; j < N; j++)
			data2[j] = sc.nextInt();

		Arrays.sort(data1);
		Arrays.sort(data2);

		for (int k = 0; k < K; k++) {
			if (data1[k] < data2[N - 1 - k])
				data1[k] = data2[N - 1 - k];
			else
				break;
		}

		for (int i = 0; i < N; i++)
			sum += data1[i];

		System.out.println(sum);

	}

}
