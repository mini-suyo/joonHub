import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int[][] maze;
	static int tc, result;
	static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
	static boolean[][] visited;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		for (tc = 1; tc <= 10; tc++) {
			int trash = sc.nextInt();

			maze = new int[16][16];
			for (int i = 0; i < 16; i++) {
				String tmp = sc.next();
				for (int j = 0; j < 16; j++) {
					maze[i][j] = tmp.charAt(j) - '0';
				}
			}

			// tc마다 초기화
			result = 0;
			visited = new boolean[16][16];

			bfs();

		}

	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(1, 1));
		visited[1][1] = true;

		while (!q.isEmpty()) {
			Point curr = q.poll();
			for (int d = 0; d < 4; d++) {
				int nextX = curr.x + dx[d];
				int nextY = curr.y + dy[d];

				if (maze[nextY][nextX] == 0 && !visited[nextY][nextX]) {
					q.add(new Point(nextX, nextY));
					visited[nextY][nextX] = true;
				} else if (maze[nextY][nextX] == 3) {
					System.out.println("#" + tc + " 1");
					return;
				}

			}
		}
		System.out.println("#" + tc + " 0");

	}

}