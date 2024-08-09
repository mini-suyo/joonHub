import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] flag = new char[N][M];
			int result = 0;

			// flag배열에 값 넣기
			for (int i = 0; i < N; i++) {
				String tmp = sc.next();
				for (int j = 0; j < M; j++) {
					flag[i][j] = tmp.charAt(j);
				}
			}

			int cnt = Integer.MAX_VALUE;
			for (int whiteLimit = 1; whiteLimit <= N - 2; whiteLimit++) {
				for (int blueLimit = whiteLimit + 1; blueLimit <= N - 1; blueLimit++) {

					int whiteCount = 0;
					int blueCount = 0;
					int redCount = 0;

					for (int i = 0; i < whiteLimit; i++) {
						for (int j = 0; j < flag[0].length; j++) {
							if (flag[i][j] != 'W') {
								whiteCount++;
							}
						}
					}

					for (int i = whiteLimit; i < blueLimit; i++) {
						for (int j = 0; j < flag[0].length; j++) {
							if (flag[i][j] != 'B') {
								blueCount++;
							}
						}
					}

					for (int i = blueLimit; i < N; i++) {
						for (int j = 0; j < flag[0].length; j++) {
							if (flag[i][j] != 'R') {
								redCount++;
							}
						}
					}

					cnt = Math.min(cnt, (whiteCount + blueCount + redCount));

				}
			}
			System.out.println("#" + t + " " + cnt);

		}

	}

}
