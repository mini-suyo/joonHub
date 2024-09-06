import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[][] branch;
	static boolean[] visited;
	static Queue<Integer> queue;
	static int N, V, M;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		branch = new int[1001][1001];
		visited = new boolean[1001];

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			branch[a][b] = branch[b][a] = 1;
		}

		dfs(V);
		System.out.println();

		visited = new boolean[1001];
		bfs(V);
	}

	static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		for (int i = 1; i <= N; i++) {
			if (branch[start][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}

	static void bfs(int start) {
		queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		System.out.print(start + " ");

		while (!queue.isEmpty()) {
			int tmp = queue.poll();

			for (int i = 1; i < branch.length; i++) {
				if (branch[tmp][i] == 1 && visited[i] == false) {
					queue.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}
