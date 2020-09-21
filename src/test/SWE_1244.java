package test;

import java.util.Scanner;

public class SWE_1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test_case = sc.nextInt();
		for (int i = 0; i < test_case; i++) {
			String data = sc.next();
			String sorted_ = "";
			int cnt = sc.nextInt();

			int[] arr = new int[data.length()];
			int[] sorted;

			for (int j = 0; j < data.length(); j++) {
				int tmp = data.charAt(j) - '0';
				arr[j] = tmp;
			}

			sorted = arr.clone();

			for (int k = sorted.length - 1; k > 0; k--) {
				for (int j = 0; j < k; j++) {
					if (sorted[j] < sorted[j + 1]) {
						int tmp = sorted[j];
						sorted[j] = sorted[j + 1];
						sorted[j + 1] = tmp;
					}
				}
			}
			for (int k = 0; k < sorted.length; k++) {
				sorted_ += String.valueOf(sorted[k]);
			}

			for (int j = 0; j < arr.length; j++) {

				if (arr[j] != sorted[j]) {
					System.out.println("1");
					int tmp = arr[j];
					int idx = sorted_.indexOf((char) (tmp + '0'));
					if (sorted[j] == arr[idx]) {
						arr[j] = arr[idx];
						arr[idx] = tmp;
					}
					else {
						idx = data.indexOf((char) (tmp + '0'));
						arr[j] = arr[idx];
						arr[idx] = tmp;
					}
				}
				System.out.print("arr.equals(sorted) : " + arr.equals(sorted));
				if(arr.equals(sorted)) {
					
					int tmp = arr[arr.length-1];
					arr[arr.length-1] = arr[arr.length-2];
					arr[arr.length-2] = tmp;
				}
				cnt--;
				if (cnt <= 0)
					break;
			}

			System.out.print("#" + (i + 1) + " ");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j]);
			}
			System.out.println("");
		}
	}

}
