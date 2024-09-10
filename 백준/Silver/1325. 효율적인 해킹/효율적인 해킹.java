import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer>[] adjList;
	static int N,M;
	static boolean[] visited;
	static int[] count;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 컴퓨터 개수
		int M = sc.nextInt(); // 간선 개수
		int max = 0;
		
		adjList = new ArrayList[N+1];
		count = new int[N+1];
		
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adjList[B].add(A);
		}
		for (int i = 1; i <= N; i++) {
			visited= new boolean[N+1];
			bfs(i);
		}
		
		for (int i = 1; i <= N; i++) {
			if(count[i] > max) {
				max = count[i];
			}
		}
		for (int i = 1; i <= N; i++) {
			if(count[i] == max) {
				System.out.print(i+" ");
			}
		}
		
		
//		System.out.println(Arrays.toString(count));
		
	}

	private static void bfs(int idx) {
		
		Queue<Integer> queue = new LinkedList<>();
		
		visited[idx] = true;
		queue.add(idx);
		int cnt = 0;

		while(!queue.isEmpty()) {
			int curr = queue.poll();
			cnt++;
			for (Integer i : adjList[curr]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		count[idx] = cnt;
	}
}
/*
 A가 B를 신뢰하는 경우 -> B를 해킹하면 A도 해킹할 수 있음
  
 */
