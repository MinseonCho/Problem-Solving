package test;
import java.util.*;
public class SWE_1206 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int answer = 0;
		
		for(int k = 0; k < 10; k++) {
			answer = 0;
			int len = sc.nextInt();
			for(int i =0; i<len; i++) {
				list.add(sc.nextInt());
				
				if(list.size() == 5) {
					
					int max = -1;
					int[] arr = {0,1,3,4};
					for(int j : arr) {
						if(list.get(j) > max ) max = list.get(j);
					}
					if( max < list.get(2)) answer += list.get(2) - max;
					
//					System.out.println("list : " + list.toString() + "  max:  " + max + " answer : " + answer);
					list.remove(0);
				}
				
			}
			
			System.out.println("#" + k + " " + answer);
			
		}
	}

}
