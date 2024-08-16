import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// 델타 생성
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		// 대각선 델타 생성
		int[] xdr = { -1, 1, 1, -1 };
		int[] xdc = { 1, 1, -1, -1 };

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];

			// 값 map배열에 삽입
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 십자가 확인
			int crossSum = 0; // 십자가로 찍은 합
			int result = 0; // 결과
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					crossSum = map[r][c];
					for (int m = 1; m < M; m++) {
						for (int d = 0; d < 4; d++) {
							int nr = r + dr[d] * m;
							int nc = c + dc[d] * m;
							if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
								crossSum += map[nr][nc];
							}
						}
					}
					if (result < crossSum) {
						result = crossSum;
					}
				}
			}

			int diagoSum = 0; // x자로 찍은 합
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					diagoSum = map[r][c];
					for (int m = 1; m < M; m++) {
						for (int d = 0; d < 4; d++) {
							int nr = r + xdr[d] * m;
							int nc = c + xdc[d] * m;
							if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
								diagoSum += map[nr][nc];
							}
						}
					}
					if (result < diagoSum) {
						result = diagoSum;
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

}