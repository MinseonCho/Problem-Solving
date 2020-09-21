package test;

import java.util.Scanner;

//곱하기 혹은 더하기 312p

public class Algorithm_prac_no21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		int[] input = new int[s.length()];

		for (int i = 0; i < s.length(); i++)
			input[i] = s.charAt(i) - '0';

		int result = input[0];
		for (int i = 1; i < input.length; i++) {
			if (input[i] <= 1 || result <= 1)
				result += input[i];
			else
				result *= input[i];

		}

		System.out.println("resultl = " + result);
	}

}
