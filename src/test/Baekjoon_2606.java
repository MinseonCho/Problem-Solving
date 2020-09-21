package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon_2606 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] a;
		int n , e;
		boolean[] visit;
		n= sc.nextInt();
		a= new int[n+1][n+1];
		visit = new boolean[n+1];
		e= sc.nextInt();
		
		for(int i=0; i<e; i++) {
			int v1, v2;
			v1= sc.nextInt();
			v2= sc.nextInt();
			
			a[v1][v2] = 1;
			a[v2][v1] = 1;
		}
		
		sc.close();
		
		bfs(a,visit,1);
		
	}
	
	public static void bfs(int[][] a, boolean[] visit, int start) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		visit[start] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			
			for(int i =1; i<a.length; i++) {
				if(a[num][i] == 1 && visit[i] == false ) {
					visit[i] = true;
					count++;
					q.add(i);
				}
			}
		}
		
		System.out.println(count);
	}

}
