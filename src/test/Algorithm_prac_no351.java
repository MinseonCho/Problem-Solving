package test;

import java.util.*;

// �������ϱ�
public class Algorithm_prac_no351 {
	private static int n; // �� ũ��
	private static char[][] graph;
	private static ArrayList<Poin> empty = new ArrayList<Poin>(); // ����� ��ǥ ����
	private static ArrayList<Poin> teacher = new ArrayList<Poin>(); // ������ ��ǥ ����
	private static int[] dx = { -1, 1, 0, 0 }; // �����¿�
	private static int[] dy = { 0, 0, -1, 1 };
	private static boolean result = false;

	// �������� �л��� �� �� �ִ��� �˻�
	// return 1 : �� �� ����. return 0 : �� �� ����.
	private static int calcul() {
		for (int i = 0; i < teacher.size(); i++) {
			for (int j = 0; j < 4; j++) {
				int nx = teacher.get(i).x + dx[j];
				int ny = teacher.get(i).y + dy[j];
				while (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					// �л��� ������ �� �� ������ �ǹ��� 1 return
					if (graph[nx][ny] == 'S')
						return 1;
					// ��ֹ��̳� ������ ������ �� ���⿡���� �л��� �Ⱥ��̴� �ɷ� �ϰ� ���� ������ ��ġ�� �Ѿ
					else if (graph[nx][ny] == 'O' || graph[nx][ny] == 'T')
						break;
					// ������̸� ��ĭ �� �̵�
					nx += dx[j];
					ny += dy[j];
				}
			}
		}
		return 0;
	}

	// ��ֹ� ����
	private static void dfs(int cnt, int idx) {
		if (cnt == 3) {
			if (calcul() == 0) // �˻��ؼ� �� �� ������
			{
				result = true;
			}
			return;
		}

		for (int i = idx; i < empty.size(); i++) {
			int x = empty.get(i).x;
			int y = empty.get(i).y;
			graph[x][y] = 'O';
			dfs(++cnt, i + 1);
			// �������������
			if (result)
				return;
			cnt--;
			graph[x][y] = 'X';
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		graph = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				char tmp = sc.next().charAt(0);
				graph[i][j] = tmp;
				if (tmp == 'X')
					empty.add(new Poin(i, j));
				else if (tmp == 'T')
					teacher.add(new Poin(i, j));
			}
		}

		dfs(0, 0);
		
		if (result)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
