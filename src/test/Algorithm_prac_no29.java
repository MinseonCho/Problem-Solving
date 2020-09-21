package test;

import java.util.Scanner;

// 자물쇠와 열쇠 325p

public class Algorithm_prac_no29 {
	private static int[][] key;
	private static int[][] lock;
	private static int cnt = 0;

	
	//왼쪽으로 90도 회전
	public static int[][] rotate(int[][] key) {

		int len = key.length;
		int idx = len - 1;

		int[][] tmpKey = new int[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				// 왼쪽으로 90도 회전
				tmpKey[i][j] = key[idx - j][i];
			}
		}
		return tmpKey;
	}

	public static boolean check(int key_len, int lock_len) {
		int[][] check = new int[lock_len * 3][lock_len * 3];
		boolean answer = true;

		// lock을 check 가운데 위치시킴
//		int idx = len - 1;
		for (int x = lock_len; x < lock_len * 2; x++) {
			for (int y = 0; y < lock_len; y++) {
				check[x][y + lock_len] = lock[x - lock_len][y];
			}
		}

		// (1,1)부터 시작
		int start_i = 1;
		int start_j = 1;
		while (start_i < lock_len * 2) {

			// check 복사
			int[][] tmp = new int[lock_len * 3][lock_len * 3];
			for (int i = 0; i < tmp.length; i++) {
				for (int j = 0; j < tmp.length; j++) {
					tmp[i][j] = check[i][j];
				}
			}

			// 탐색
			int key_x = 0, key_y = 0;
			for (int x = start_i; x < start_i + key_len; x++) {
				for (int y = start_j; y < start_j + key_len; y++) {
					tmp[x][y] += key[key_x][key_y];
					key_y++;
				}
				key_y = 0;
				key_x++;
			}

			// 검사
			answer = true;
			for (int x = lock_len; x < lock_len * 2; x++) {
				for (int y = lock_len; y < lock_len * 2; y++) {
					if (tmp[x][y] != 1) {
						answer = false;
						break;
					}
				}
			}

			// 맞으면 break
			// 틀리면 다음 탐색
			if (answer) {
				break;
			} else {
				if (start_j >= lock_len * 2 - 1) {
					start_j = 1;
					start_i++;
				} else {
					start_j++;
				}

				tmp = check.clone();
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		key = new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		lock = new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		int len = key.length;
		int idx = len - 1;
		boolean answer;
		do {
			answer = check(len, lock.length);
			if (!answer) {
				cnt++;
				key = rotate(key);
			} else
				break;
		} while (cnt < 4);

		System.out.println(answer);

	}

}
