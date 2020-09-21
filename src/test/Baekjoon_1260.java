package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class Baekjoon_1260 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean[] visit; 
		int[][] a;
		int numV, numN, numM; //시작할 정점 V ,정점의 갯수, 간선의 갯수
		int v1,v2;
		numN = sc.nextInt();
		numM = sc.nextInt();
		numV = sc.nextInt();
		
		a = new int[numN+1][numN+1];
		visit = new boolean[numN+1];
		
		for(int i=0; i<numM; i++) {
			v1 = sc.nextInt();
			v2 = sc.nextInt();
			
			a[v1][v2] = 1;
			a[v2][v1] = 1;
		}
		sc.close();
		//인접행렬 만들기
		
		dfs(a,numV,visit,true);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(a,visit,numV);
		
	}
	
	public static void dfs(int[][] a, int numV, boolean[] visit, boolean flag) {
		Stack<Integer> stack = new Stack<>();
		
		visit[numV] = true;
		stack.push(numV);
		System.out.print(numV + " ");
		
		while(!stack.isEmpty()) {
			int p = stack.peek();
			
			flag = false;
			
			for(int i = 1; i<a.length; i++) {
				if(a[p][i] == 1 && !visit[i]) {
					stack.push(i);
					flag = true;
					dfs(a,i,visit, true);
				}
			}
			
			if(!flag) {
				stack.pop();
			}
		}
	}
	
	public static void bfs(int[][] a, boolean[] visit, int numV) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(numV);
		visit[numV] = true;
		
		
		while(!q.isEmpty()) {
			int n = q.poll();
			
			System.out.print(n + " ");
			
			for(int i=1; i<a.length; i++) {
				if(a[n][i] == 1 && !visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}

}
