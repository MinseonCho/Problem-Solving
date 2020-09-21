package test;

import java.util.*;

class SameData {
	
	int index;
	int value;
	
	public SameData(int i, int v) {
		this.index = i;
		this.value = v;
	}
	
}
public class SWE_1204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		
		int test_case = sc.nextInt();
		for(int i=0; i<test_case; i++) {
			ArrayList<SameData> list = new ArrayList<SameData>();
			
			int[] arr = new int[101];
			
			int num = sc.nextInt();
			for(int j =0; j<1000; j++) {
				int tmp = sc.nextInt();
				arr[tmp] += 1;
			}
			
			SameData max = new SameData(0, arr[0]);
			
			for(int k = 1; k < 101; k++) {
				if(max.value == arr[k]) list.add(new SameData(k, arr[k]));
				else if(max.value < arr[k]) {max.value = arr[k]; max.index = k;}
			}
			
			for(int k =0; k<list.size(); k++) {
				if(max.index < list.get(k).index && max.value == list.get(k).value) {
					max.value = list.get(k).value;
					max.index = list.get(k).index;
				}
			}
			
			System.out.println("#"+num + " " + max.index);
			

			
		}
	}

}
