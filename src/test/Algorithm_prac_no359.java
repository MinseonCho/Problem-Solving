package test;

import java.util.*;

//±¹¿µ¼ö
class Students implements Comparable<Students> {
	private String name;
	private int kor, mth, eng;

	public Students(String name, int kor, int eng, int mth) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mth = mth;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMth() {
		return mth;
	}

	@Override
	public int compareTo(Students o) {
		if (this.kor == o.kor && this.eng == o.eng && this.mth == o.mth)
			return this.name.compareTo(o.name);
		if (this.kor == o.kor && this.eng == o.eng)
			return Integer.compare(o.mth, this.mth);
		if (this.kor == o.kor)
			return Integer.compare(this.eng, o.eng);

		return Integer.compare(o.kor, this.kor);
	}

}

public class Algorithm_prac_no359 {

	public static int n, kor, mth, eng;
	public static String name;
	public static ArrayList<Students> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int mth = sc.nextInt();
			list.add(new Students(name, kor, eng, mth));
		}
		Collections.sort(list);
		for (int i = 0; i < n; i++) {
			System.out.println(list.get(i).getName());
		}
	}

}
