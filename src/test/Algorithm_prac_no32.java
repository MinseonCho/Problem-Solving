package test;

import java.util.*;

// 기둥과 보 설치 329p

class Build implements Comparable<Build> {
	private int x, y, type;

	public Build(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public int compareTo(Build o) {
		if (this.x < o.getX())
			return -1;
		else if (this.x == o.getX()) {
			if (this.y == o.getY()) {
				return this.type > o.getType() ? 1 : -1;
			} else
				return this.y > o.getY() ? 1 : -1;
		} else
			return 1;
	}

}

public class Algorithm_prac_no32 {

	private static int[][] build_frame = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 2, 1, 1 },
			{ 3, 0, 0, 1 }, { 2, 1, 1, 1 }, { 2, 1, 0, 1 } };
	private static ArrayList<Build> list = new ArrayList<>();

	private static void solution() {
		for (int i = 0; i < build_frame.length; i++) {
			int[] data = build_frame[i];
			int x = data[0];
			int y = data[1];
			int a = data[2]; // 0 : 기둥, 1 : 보
			int b = data[3]; // 0 : 삭제, 1 : 설치

			if (b == 1) {
				// 설치면
				if (setup(x, y, a)) {
					list.add(new Build(x, y, a));
				}
			} else {
				delete(x, y, a);
			}
		}

		Collections.sort(list);
		for (Build o : list) {
			System.out.println(o.getX() + " " + o.getY() + " " + o.getType());
		}
	}

	private static boolean check() {
		Collections.sort(list);
		boolean result = true;
		for (Build tmp : list) {
			int x = tmp.getX();
			int y = tmp.getY();
			int a = tmp.getType();

			if (a == 0) { // 기둥일 때
				if (y == 0)
					continue;
				else {
					boolean flag = false; // 기둥이 있으면 true로 바뀜
					for (Build t : list) {
						if (t.getX() == x && t.getY() == y - 1 && t.getType() == a) { // 밑에 기둥있으면
							flag = true;
							break;
						}
						if ((t.getX() == x && t.getY() == y && t.getType() == 1)
								|| (t.getX() == x - 1 && t.getY() == y && t.getType() == 1)) { // 밑에 보가 있으면
							flag = true;
							break;
						}
					}
					if (flag)
						continue;
					else {
						result = false; // 기둥이 바닥에 세워져 있는 것도 아니고, 아래 기둥이 있는 것도 아니고, 보가 있는 것도 아니면 result = false;
						break;
					}
				}

			} else {
				// 보일 때
				boolean flag_b = false; // 양쪽에 보가 있는지 확인
				boolean flag = false; // 양쪽에 보가 있는지 최종
				boolean flag_p = false;
				for (Build t : list) {
					if (t.getX() == x - 1 && t.getY() == y && t.getType() == 1) { // 왼족에 보가 있으면
						if (flag_b) {
							// 왼쪽, 오른쪽에 모두 보가 있으면
							result = true;
							flag = true;
							break;
						} else {
							flag_b = true;
							continue;
						}
					}
					if (t.getX() == x + 1 && t.getY() == y && t.getType() == 1) { // 오른족에 보가 있으면
						if (flag_b) {
							// 왼쪽, 오른쪽에 모두 보가 있으면
							result = true;
							flag = true;
							break;
						} else {
							flag_b = true;
							continue;
						}
					}
					// 보 양쪽 아래에 기둥이 하나라도 있으면
					if ((t.getX() == x && t.getY() == y - 1 && t.getType() == 0)
							|| (t.getX() == x + 1 && t.getY() == y - 1 && t.getType() == 0)) {
						result = true;
						flag_p = true;
						break;
					}
				}

				if (!flag_p && !flag) {
					result = false;
					break;
				}
			}
		}

		return result;
	}

	private static boolean delete(int x, int y, int a) {
		boolean result = false;
		for (int i = 0; i < list.size(); i++) {
			int tmp_x = list.get(i).getX();
			int tmp_y = list.get(i).getY();
			int tmp_a = list.get(i).getType();
			if (tmp_x == x && tmp_y == y && tmp_a == a) {
				list.remove(i);
			}

		}

		if (!check()) {
			// 삭제불가능 다시 넣어..
			list.add(new Build(x, y, a));
		}

		return result;
	}

	private static boolean setup(int x, int y, int a) {
		boolean result = false;
		if (a == 0) {
			// 기둥 설치인 경우
			if (y == 0) // 바닥에 설치하는 경우
				result = true;
			else {
				for (Build tmp : list) {
					// 현재 위치 아래에 기둥이 있는지 여부 검사
					if (tmp.getX() == x && tmp.getY() == y - 1 && tmp.getType() == 0) {
						result = true;
						break;
					}
					// 보 위에 세워질 수 있는지 확인
					if ((tmp.getX() == x - 1 && tmp.getY() == y && tmp.getType() == 1)
							|| (tmp.getX() == x && tmp.getY() == y && tmp.getType() == 1)) {
						result = true;
						break;
					}
				}
			}

		} else {
			// 보 설치인 경우
			int num = 0; // 보 개수, 2이면 true
			if (y == 0) {
				result = false;
			} else {
				for (Build tmp : list) {
					// 양쪽에 기둥이 하나라도 있는지 검사
					if (tmp.getX() == x && tmp.getY() == y - 1 && tmp.getType() == 0) {
						result = true;
						break;
					}
					if (tmp.getX() == x + 1 && tmp.getY() == y - 1 && tmp.getType() == 0) {
						result = true;
						break;
					}
					// 양쪽에 보가 있는지 검사
					if (tmp.getX() == x - 1 && tmp.getY() == y && tmp.getType() == 1) {
						num++;
					}
					if (tmp.getX() == x + 1 && tmp.getY() == y && tmp.getType() == 1) {
						num++;
					}
					if (num == 2) {
						result = true;
						break;
					} else
						continue;

				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		solution();
	}

}
