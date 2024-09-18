import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int w, h, result;
	static int[][] map;
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static boolean[][] visited;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			
			// 0 0 을 입력받으면 종료
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			result = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						result++;
						bfs(i, j);
					}
				}
			}
			System.out.println(result);
		}
	}

	static void bfs(int y, int x) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			int currX = tmp.x;
			int currY = tmp.y;
			for (int d = 0; d < 8; d++) {
				int ny = currY + dy[d];
				int nx = currX + dx[d];
				if (nx >= 0 && ny >= 0 && nx < w && ny < h && map[ny][nx] == 1 && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.add(new Node(nx, ny));
				}

			}

		}

	}

}
