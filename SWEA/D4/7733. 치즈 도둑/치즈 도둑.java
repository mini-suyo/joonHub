import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int N, rslt;
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			cheese = new int[N][N];

			int day = 0; // 먹을 수 있는 최대 일 수
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					if (day < cheese[i][j])
						day = cheese[i][j];
				}
			}
			// 초기화
			rslt = 1;
			// 하루씩 덩어리 수 세기
			for (int i = 1; i <= day; i++) {
				visited = new boolean[N][N];
				int cnt = 0; // 매일 갱신되는 덩어리 수

				// 요정이 먹은 치즈 체크
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (cheese[r][c] <= i)
							visited[r][c] = true;
					}
				}

				// 덩어리 수 세기
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (!visited[r][c]) {
							cnt++;
							bfs(r, c);
						}
					}
				}
				if (rslt < cnt)
					rslt = cnt;
			}
			System.out.println("#" + tc + " " + rslt);
		}

	}

	static void bfs(int y, int x) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			Point curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = curr.x + dx[d];
				int ny = curr.y + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[ny][nx]) {
					visited[ny][nx] = true;
					q.add(new Point(nx, ny));
				}
			}

		}

	}
}
