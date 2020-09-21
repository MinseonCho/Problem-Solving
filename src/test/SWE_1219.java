package test;
import java.util.*;

public class SWE_1219 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		
		for(int r = 0; r<10; r++) {
			int answer = 0;
			Stack<Integer> st = new Stack<Integer>();
			
			int[][] arr = new int[100][2];
			int test_case = sc.nextInt();
			int len = sc.nextInt();
			
			for(int i =0; i< len; i++) {
				int idx = sc.nextInt();
				int value = sc.nextInt();
				if(arr[idx][0] == 0)
					arr[idx][0] = value;
				else
					arr[idx][1] = value;
				
			}
			
//			for(int i =0; i<16; i++) {
//				System.out.println(arr[i][0] + "  " + arr[i][1]);
//			}
			
			st.add(0);
			while(!st.isEmpty()) {
				int tmp = st.pop();
				
				if(tmp == 99) {
					answer = 1;
					break;
				}
				
				if(arr[tmp][0] != 0) st.add(arr[tmp][0]);
				if(arr[tmp][1] != 0) st.add(arr[tmp][1]);
				
//				for(int q = 0; q<st.size(); q++) {
//					System.out.print( st.get(q) + "  ");
//				}
//				System.out.println("");

			}
		
			System.out.print("#" + test_case + " " + answer + "\n");
			
		
		}
	
	}

}
