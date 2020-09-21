package test;

import java.util.Scanner;

public class Baekjoon_15953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int[] fes1 =  {1 , 5000000, 2, 3000000, 3, 2000000, 4, 500000, 
				5, 300000, 6, 100000};
		
		int[] fes2 = {1,5120000,2,2560000,4,1280000,8,640000,16, 320000};
		
		int num;
		int sum1=0, sum2 =0;
		
		
		num = sc.nextInt();
		
		int[] result = new int[num];
		int[] gd1 = new int[num];
		int[] gd2 = new int[num];
		
		int j=0;
		
		for(int i=0; i<num; i++) {
			gd1[i] = sc.nextInt();
			gd2[i] = sc.nextInt();
		}
		
		sc.close();
		
		while(j != result.length){

			
			for(int i=0; i<fes1.length; i++) {
				sum1+=fes1[i];
						
				if(gd1[j] != 0) {
					if(gd1[j]<=sum1) {
						result[j] += fes1[i+1];
						sum1=0;
						break;
					}
				}else {
					result[j] += 0;
					sum1=0;
					break;
				}
					
				i++;
			}
			
			for(int i=0; i<fes2.length; i++) {
				sum2+=fes2[i];
				
				if(gd2[j] != 0) {
					if(gd2[j] <= sum2) {
						result[j] += fes2[i+1];
						sum2=0;
						break;
					}
				}else {
					result[j] += 0;
					sum2=0;
					break;
				}
				
				i++;
			}
			
			j++;
			
		}
		
		for(int i=0; i<num; i++) {
			System.out.println(result[i]);
		}
		
	}

}
