package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Baekjoon_11726 {
	
	static int[] tile = new int[1001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		tile[1] = 1;
		tile[2] = 2;

		System.out.println(tiling(n));
	}
	
	public static int tiling(int n) {
		if(tile[n] != 0)
			return tile[n];
		
		tile[n] = (tiling(n-1) + tiling(n-2)) % 10007;
		
		return tile[n];
	
	}
}
