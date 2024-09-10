import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M,K,X;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 도시의 개수 -> 정점 개수
		M = sc.nextInt(); // 도로의 개수 -> 간선 개수
		K = sc.nextInt(); // 최단 거리
		X = sc.nextInt(); // 출발 도시의 번호
		
		visited = new boolean[N+1];
		adjList = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adjList[A].add(B);
		}
		
		bfs(X);
		
	}

	private static void bfs(int V) {
		Queue<int[]> queue = new LinkedList<>();
		PriorityQueue<Integer> squeue = new PriorityQueue<>();
		
		visited[V] = true;
		queue.add(new int[]{V,0});
		
		boolean check = false; //확인
		
		while(!queue.isEmpty()) {
				int[] curr = queue.poll();
				
				int city = curr[0];
				int dist = curr[1];
				if(dist == K) {
					squeue.add(city);
					check = true;
					continue;
				}
				for (int i : adjList[city]) {
					if(!visited[i]) {
						visited[i] =true;
						queue.add(new int[]{i,dist+1});
					}
				}
								
		}
		if(!check) {
			System.out.println(-1);
		} else 
			while(!squeue.isEmpty()) {
				System.out.println(squeue.poll());
			}
	}
}
