import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			int N = sc.nextInt(); // 배열의 크기
			int[][] map = new int[N][N];

			// map에 값 입력
			for (int i = 0; i < map.length; i++) {
				String str = sc.next();
				char[] temp = str.toCharArray();
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = Character.getNumericValue(temp[j]);
				}
			}

			int result = 0;
			for (int i = 0; i < map.length / 2 + 1; i++) {
				for (int j = N / 2 - i; j <= N / 2 + i; j++) {
					result += map[i][j];
				}
			}

			for (int i = N / 2 + 1; i < N; i++) {
				for (int j = i - N / 2; j <= 3 * N / 2 - i - 1; j++) {
					result += map[i][j];
				}
			}

			System.out.println("#" + (t + 1) + " " + result);
		}
	}
}