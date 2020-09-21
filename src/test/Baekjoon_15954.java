package test;

import java.util.Scanner;

public class Baekjoon_15954 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n,k;
		double aver;
		int[] pf;
		n=sc.nextInt();
		k=sc.nextInt();
		pf=new int[n];
		for(int i=0; i<n; i++) {
			pf[i] = sc.nextInt();
		}
		
		sc.close();
		
		double result = Double.MAX_VALUE;
		
		while(k <= n) {
			for(int i=0; i<=n-k; i++) {
				aver = avrg(pf,i,k);
				
				double b = cal(pf,aver,i,k);
				
				result = Math.min(result,b);
			}
			k+=1;
		}
		
		double newResult = Double.parseDouble(
				String.format("%.11f", result));
		System.out.println(newResult);
	}
	
	public static double avrg(int[] pf, int i, int k) {
		double sum =0.0;
		
		for(int j=0; j<k; j++) {
			sum += pf[i+j];
		}
		
		return sum/(double)k;
		
	}
	
	public static double cal(int[] pf, double ag, int st, int k) {
		double sum=0.0;
		for(int i=0; i<k; i++) {
			sum += (Math.pow(pf[i+st]-ag, 2));
		}
		
		return Math.sqrt(sum/(double)k);
	}

}
