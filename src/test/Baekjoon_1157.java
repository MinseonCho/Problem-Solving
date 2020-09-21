package test;

import java.util.Scanner;

public class Baekjoon_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		sc.close();
		String upS = s.toUpperCase(); 
		
		int[] al = new int[26];
		for(int i=0; i<upS.length(); i++) {
			al[(int)upS.charAt(i)-65] += 1; 
		}
		int resultIndex=0, result =0;
		for(int i=0; i<al.length; i++) {
			if(result < al[i]) {
				result = al[i];
				resultIndex = i;
			}
			else
				continue;
		}
		
		for(int i=resultIndex+1; i<al.length; i++) {
			if(result == al[i]) {
				System.out.println("?");
				return;
			}
		}
		System.out.println((char)(resultIndex+65));
		
	}

}
