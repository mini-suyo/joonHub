import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 저수지의 크기
			int[][] map = new int[N][N];

			// G는 0, W는 1로 설정
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					String tmp = sc.next();
					if (tmp.equals("G")) {
						map[i][j] = 0;
					} else {
						map[i][j] = 1;
					}
				}
			}

			int cnt = 0;
			int max = Integer.MIN_VALUE;
			for (int i = 1; i < N - 1; i++) {
				for (int j = 1; j < N - 1; j++) {
					cnt = 0;
					if (map[i - 1][j - 1] == 1) {
						cnt++;
					}
					if (map[i - 1][j] == 1) {
						cnt++;
					}
					if (map[i - 1][j + 1] == 1) {
						cnt++;
					}
					if (map[i][j - 1] == 1) {
						cnt++;
					}
					if (map[i][j + 1] == 1) {
						cnt++;
					}
					if (map[i + 1][j - 1] == 1) {
						cnt++;
					}
					if (map[i + 1][j] == 1) {
						cnt++;
					}
					if (map[i + 1][j + 1] == 1) {
						cnt++;
					}
					if (cnt == 0) {
						cnt++;
					}
					if (max < cnt) {
						max = cnt;
					}
				}
			}
			System.out.println("#" + t + " " + max);

		}

	}

}
