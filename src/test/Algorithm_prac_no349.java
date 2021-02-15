package test;

import java.util.*;

// 연산자 끼워넣기
// 순열, DFS로 풀 수 있음

// DFS 방법
public class Algorithm_prac_no349 {

	public static int n;
	// 연산을 수행하고자 하는 수 리스트
	public static ArrayList<Integer> arr = new ArrayList<>();
	public static char[] operator;
	public static boolean[] visited;
	// 더하기, 빼기, 곱하기, 나누기 연산자 개수
	public static int add, sub, mul, divi;

	// 최솟값과 최댓값 초기화
	public static int minValue = (int) 1e9;
	public static int maxValue = (int) -1e9;

	// 깊이 우선 탐색 (DFS) 메서드
	public static void dfs(int i, int now) {
		// 모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트

		if (i == n) {
			minValue = Math.min(minValue, now);
			maxValue = Math.max(maxValue, now);
		} else {
			for (int j = 0; j < operator.length; j++) {
				char o = operator[j];
				if (o == '+' && !visited[j]) {
					visited[j] = true;
					dfs(i + 1, now + arr.get(i));
					visited[j] = false;
				}
				if (o == '-' && !visited[j]) {
					visited[j] = true;
					dfs(i + 1, now - arr.get(i));
					visited[j] = false;
				}
				if (o == '*' && !visited[j]) {
					visited[j] = true;
					dfs(i + 1, now * arr.get(i));
					visited[j] = false;
				}
				if (o == '/' && !visited[j]) {
					visited[j] = true;
					dfs(i + 1, now / arr.get(i));
					visited[j] = false;
				}

			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		operator = new char[n - 1];
		visited = new boolean[n - 1];

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			arr.add(x);
		}
		add = sc.nextInt();
		int j = 0;
		for (int i = 0; i < add; i++) {
			operator[j++] = '+';
		}
		sub = sc.nextInt();
		for (int i = 0; i < sub; i++) {
			operator[j++] = '-';
		}
		mul = sc.nextInt();
		for (int i = 0; i < mul; i++) {
			operator[j++] = '*';
		}
		divi = sc.nextInt();
		for (int i = 0; i < divi; i++) {
			operator[j++] = '/';
		}

		// DFS 메서드 호출
		dfs(1, arr.get(0));

		// 최댓값과 최솟값 차례대로 출력
		System.out.println(maxValue);
		System.out.println(minValue);
	}
}

//순열 방법
//public class Algorithm_prac_no349 {
//	public static int n; // 수의개수
//	public static ArrayList<Character> operator = new ArrayList<>();
//	public static boolean[] visited;
//	public static ArrayList<Integer> number = new ArrayList<>();
//	public static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n = sc.nextInt();
//		visited = new boolean[n - 1];
//
//		for (int i = 0; i < n; i++) {
//			number.add(sc.nextInt());
//		}
//		for (int i = 0; i < 4; i++) {
//			int tmp = sc.nextInt();
//
//			for (int j = 0; j < tmp; j++) {
//				if (i == 0) {
//					operator.add('+');
//				} else if (i == 1)
//					operator.add('-');
//				else if (i == 2)
//					operator.add('*');
//				else
//					operator.add('/');
//			}
//		}
//		permutation(0, new char[n - 1]);
//		System.out.println(max + "\n" + min);
//	}
//
//	public static void calcul(char[] operator) {
//		int num = number.get(0);
//		
//		for (int i = 0; i < operator.length; i++) {
//			char o = operator[i];
//			int num2 = number.get(i+1);
//			
//			if (o == '+') {
//				num += num2;
//			} else if (o == '-')
//				num -= num2;
//			else if (o == '*')
//				num *= num2;
//			else
//				num /= num2;
//		}
//
//		if (num > max)
//			max = num;
//		if (num < min)
//			min = num;
//	}
//
//	private static void dfs(int r, char[] operator) {
//		if(r == n ) {
//			return;
//		}
//		int num = number.get(r);
//		for (int i = 0; i < n-1; i++) {
//			if(visited[i])
//				continue;
//			
//		}
//		
//	}
//	public static void permutation(int idx, char[] picked) {
//		if (idx == n - 1) {
//			calcul(picked);
//			return;
//		}
//
//		for (int i = 0; i < n - 1; i++) {
//			if (visited[i])
//				continue;
//			picked[idx] = operator.get(i);
//			visited[i] = true;
//			permutation(idx + 1, picked);
//			visited[i] = false;
//		}
//	}
//
//}
