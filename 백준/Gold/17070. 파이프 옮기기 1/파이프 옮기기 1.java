import java.util.Scanner;

public class Main {

	static int N, cnt;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		cnt = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();

		dfs(0, 1, 0);

		System.out.println(cnt);
	}

	// State = 0가로 , 1세로, 2 대각선
	static void dfs(int x, int y, int state) {
		if (x == N - 1 && y == N - 1) {
			cnt++;
			return;
		}

		if (state == 0) {
			if (y + 1 < N && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
		} else if (state == 1) {
			if (x + 1 < N && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
		} else if (state == 2) {
			if (y + 1 < N && map[x][y + 1] == 0) {
				dfs(x, y + 1, 0);
			}
			if (x + 1 < N && map[x + 1][y] == 0) {
				dfs(x + 1, y, 1);
			}
		}

		if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
			dfs(x + 1, y + 1, 2);
		}

	}

}