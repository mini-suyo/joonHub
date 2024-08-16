import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // row
			int M = sc.nextInt(); // column
			int[][] map = new int[N][M];

			// 값 입력
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int[] dr = { 0, 0, -1, 1 };
			int[] dc = { -1, 1, 0, 0 };
			int result = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int sum = map[r][c];
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
							sum += map[nr][nc];
						}
					}
					if (result < sum) {
						result = sum;
					}
				}
			}

			System.out.println("#" + t + " " + result);

		}

	}

}