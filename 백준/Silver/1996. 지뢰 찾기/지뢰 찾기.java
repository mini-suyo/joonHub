
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] map = new char[N][N];

		for (int i = 0; i < map.length; i++) {
			String str = sc.next();
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// 8방 델타
		int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

		char[][] rslt = new char[N][N];
		for (int r = 0; r < rslt.length; r++) {
			for (int c = 0; c < rslt[0].length; c++) {
				// 지뢰일 경우 *넣기
				if (map[r][c] != '.')
					rslt[r][c] = '*';
				else {
					// 주변 숫자 찾아서 넣기
					int num = 0;
					for (int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];

						if (nr >= 0 && nc >= 0 && nr < N && nc < N && (map[nr][nc] > '0' && map[nr][nc] <= '9')) {
							num += map[nr][nc] - '0';
						}

					}
					if (num > 9) {
						rslt[r][c] = 'M';
					} else {
						rslt[r][c] = (char) (num + '0');
					}
				}

			}
		}

		for (int j = 0; j < rslt.length; j++) {
			for (int k = 0; k < rslt.length; k++) {
				System.out.print(rslt[j][k]);
			}
			System.out.println();
		}

	}

}