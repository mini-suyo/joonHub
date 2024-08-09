import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int result = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if (map[j][i] == 1) {
						for (int k = j; k < map.length; k++) {
							if (map[k][i] == 2) {
								map[k][i] = 0;
								result++;
								j = k;
								break;
							}
						}

					}
				}
			}

			System.out.println("#" + (t + 1) + " " + result);

		}

	}
}