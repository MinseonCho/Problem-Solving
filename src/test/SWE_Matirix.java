package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Data{
	int i =0;
	int j =0;
	
	public Data(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class SWE_Matirix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int k =0; k< 10; k++) {

			int[][] matrix = new int[100][100];

			int[][] visited = new int[100][100];
			Queue<Data> q = new LinkedList<Data>();
			int start_i = -1, start_j = -1;
			int result = 0;
				
			
			int tmp = sc.nextInt();
			sc.nextLine();
			 for(int i=0; i<100; i++) { 
	                String rowInput = sc.nextLine();
	                for(int j=0; j<100; j++) { 
	                	matrix[i][j] = rowInput.charAt(j) - '0';
	                    if(matrix[i][j] == 2) {
	                    	start_i = i;
	                    	start_j = j;
	                    }
	                }
	         }
	
			q.offer(new Data(start_i, start_j));
			
			while(!q.isEmpty())	{
				
				Data tmp_data = q.poll();
				int j = tmp_data.i;
				int r = tmp_data.j;
				visited[j][r] = 1;
				if(matrix[j][r] == 3) {
					result = 1;
					break;
				}
				
				if(matrix[j-1][r] != 1 && visited[j-1][r] == 0) {
					q.offer(new Data(j-1, r));
				}
				if(matrix[j+1][r] != 1 && visited[j+1][r] == 0) {
					q.offer(new Data(j+1, r));
				}
				if(matrix[j][r-1] != 1 && visited[j][r-1] == 0) {
					q.offer(new Data(j, r-1));
				}
				if(matrix[j][r+1] != 1 && visited[j][r+1] == 0) {
					q.offer(new Data(j, r+1));
				}
				
			}
			
			System.out.print("#"+ tmp + " ");
			System.out.println(result);
		}
		
	}

}

