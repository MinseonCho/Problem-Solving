package test;

import java.util.*;

public class Algorithm_prac_no33 {

	private static ArrayList<Poin> chicken = new ArrayList<>(); // 치킨집 좌표
	private static ArrayList<Poin> house = new ArrayList<>(); // 치킨집 좌표

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt(); // 최대 m개의 치킨집

		// 0: 빈칸, 1: 집, 2: 치킨집
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				int tmp = sc.nextInt();
				if (tmp == 2)
					chicken.add(new Poin(i, j));
				if (tmp == 1)
					house.add(new Poin(i, j));
			}
		}
		int answer = (int) 1e9;
		for (int w = 1; w < m + 1; w++) {
			Poin[] selected = new Poin[w]; // 선택된 m개의 치킨집들의 좌표
			int idx = w - 1;
			int start = 0;
			while (start + idx < chicken.size()) {
				int by = start + idx;
				int s = 0;
				for (; start < by; start++) {
					selected[s++] = chicken.get(start);
				}
				for (int i = by; i < chicken.size(); i++) {
					selected[w - 1] = chicken.get(i); // 마지막 Poin 원소

					int min = (int) 1e9;
					int sum = 0;
					for (int j = 0; j < house.size(); j++) { // 하우스마다
						int x = house.get(j).x;// 집 좌표 x
						int y = house.get(j).y;// 집 좌표 y
						for (int k = 0; k < w; k++) { // 한 하우스가 선택된 치킨집들 모두 거리 계산
							int value = Math.abs(x - selected[k].x) + Math.abs(y - selected[k].y);
							min = (value < min) ? value : min; // 선택된 치킨집 중 가장 가까운 거리
						}
						sum += min; // 집 당 치킨거리의 합
						min = (int) 1e9;
					}
					System.out.println("몇개? " + w + "  sum : " + sum);
					answer = (sum < answer) ? sum : answer; // 도시의 치킨거리 값이 작은걸로
				}
				start++;

			}
		}
		System.out.println(answer);
	}

}
