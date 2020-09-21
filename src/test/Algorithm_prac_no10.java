package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Algorithm_prac_no10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Integer[] data = new Integer[N];
		for(int n = 0; n<N; n++)
			data[n] = sc.nextInt();
		
		Arrays.sort(data, Collections.reverseOrder());
		
		for(Integer i : data)
			System.out.print(i + " ");

	}

}
