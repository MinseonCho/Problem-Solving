package test;

import java.util.*;
class Stu implements Comparable<Stu>{
	private String name;
	private int score;
	
	Stu(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}

	@Override
	public int compareTo(Stu o) {
		if(this.score < o.score)
			return -1;
		return 1;
	}
}
public class Algorithm_prac_no180 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Stu[] arr = new Stu[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Stu(sc.next(), sc.nextInt());
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i].getName() + " ");
		}
	}

}
