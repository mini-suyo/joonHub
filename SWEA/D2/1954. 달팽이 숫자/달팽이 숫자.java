import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수 입력

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 달팽이 배열 크기
			int[][] snail = new int[N][N];

			// 우 하 좌 상
			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			// 처음 위치 설정
			int r = 0;
			int c = 0;
			int d = 0; // 진행 중인 방향 (0:우, 1:하, 2:좌, 3:상)
			for (int num = 1; num <= N * N; num++) {
				snail[r][c] = num;
				int nr = r + dr[d];
				int nc = c + dc[d];

				// 배열 밖으로 넘어가거나, 값이 있는곳으로 가려고할때 방향꺾기
				if (nr >= N || nc >= N || nr < 0 || nc < 0 || snail[nr][nc] != 0) {
					// 방향 전환
					if (d == 3) {
						d = 0;
					} else {
						d += 1;
					}
					nr = r + dr[d];
					nc = c + dc[d];
				}

				r = nr;
				c = nc;
			}

			// 결과 출력
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}