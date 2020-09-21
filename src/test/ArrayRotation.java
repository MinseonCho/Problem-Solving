package test;

public class ArrayRotation {

	public static int n = 5;
	public static int[][] arr = new int[n][n];
	
	private static int[][] rotateToLeft() {
		int[][] result = new int[n][n];

		int len = result.length;
		int lastIdx = len - 1;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				result[i][j] = arr[j][lastIdx - i];
			}
		}

		return result;
	}

	private static int[][] rotateToRight() {
		int[][] result = new int[n][n];

		int len = result.length;
		int lastIdx = len - 1;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				result[i][j] = arr[lastIdx - j][i];
			}
		}

		return result;
	}

	// 배열 출력
	private static void printArr(int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args) {

		int num = 1;
		// 값 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = num++;
			}
		}

		System.out.println("rotate to right");
		int[][] resultArr = rotateToRight();
		printArr(resultArr);
		

		System.out.println("rotate to left");
		resultArr = rotateToLeft();
		printArr(resultArr);
		
	}

}
