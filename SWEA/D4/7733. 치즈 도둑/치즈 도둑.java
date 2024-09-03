import java.util.Scanner;

public class Solution {

	static int N, rslt;
	static int[][] cheese;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			cheese = new int[N][N];
			int day = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					if (day < cheese[i][j])
						day = cheese[i][j];
				}
			}
			rslt = 1;
			for (int i = 1; i <= day; i++) {
				visited = new boolean[N][N];
				int cnt = 0;

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						// 아직 방문하지 않았고, 현재 날에 갉아먹히지 않은 치즈라면
						if (!visited[r][c] && cheese[r][c] > i) {
							dfs(r, c, i);
							cnt++;
						}
					}
				}

				// 최대 덩어리 개수 업데이트
				if (rslt < cnt) {
					rslt = cnt;
				}
			}

			System.out.println("#" + tc + " " + rslt);
		}
	}

	// 델타 탐색을 재귀적으로
	static void dfs(int r, int c, int day) {
        // 델타 배열 (상, 우, 하, 좌)
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 배열의 범위를 벗어나지 않고, 방문하지 않았으며, 갉아먹히지 않은 치즈일 경우
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && cheese[nr][nc] > day) {
                dfs(nr, nc, day);
            }
        }
    }

}
