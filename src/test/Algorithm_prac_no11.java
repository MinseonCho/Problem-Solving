package test;

import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
	String name;
	int score;

	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	@Override
	public int compareTo(Student o) {
		if (this.score < o.score) {

			return -1;

		} else if (this.score == o.score) {

			return 0;

		} else {

			return 1;

		}

	}
}

public class Algorithm_prac_no11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Student[] data = new Student[N];

		for (int i = 0; i < N; i++) {
			data[i] = new Student(sc.next(), sc.nextInt());
		}

		Arrays.sort(data);

		for (int i = 0; i < N; i++) 
			System.out.print(data[i].name + " ");

	}

}
