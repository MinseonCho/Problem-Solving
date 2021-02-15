package test;

import java.util.*;

class Stage implements Comparable<Stage> {
	private int stage;
	private double percentage;

	public Stage(int stage, double percentage) {
		this.stage = stage;
		this.percentage = percentage;
	}

	public int getStage() {
		return this.stage;
	}

	public double getPercentage() {
		return this.percentage;
	}

	@Override
	public int compareTo(Stage o) {

		if (this.percentage == o.percentage)
			return Integer.compare(this.stage, o.stage);
		return Double.compare(o.percentage, this.percentage);
	}
}

public class Algorithm_prac_no361 {
	public static int n = 4;
	public static int[] stages = { 1, 1, 1, 1 };
	public static ArrayList<Stage> list = new ArrayList<>();

	public static void main(String[] args) {
		double[] arr = new double[n + 2];
		for (int number : stages) {
			arr[number] += 1;
		}
		int num = stages.length;
		for (int i = 1; i < arr.length - 1; i++) {
			double tmp = arr[i] / num; // ½ÇÆĞÀ²
			if (arr[i] == 0)
				tmp = 0;
			list.add(new Stage(i, tmp));
			num -= arr[i];
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getStage() + " ");
		}
	}

}
