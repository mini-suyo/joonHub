import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int paper = sc.nextInt(); // 색종이의 수
		boolean[][] map = new boolean[100][100]; // 도화지 크기

		for (int i = 0; i < paper; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 받은 색종이 좌표 기준으로 10x10배열 1로 변경
			for (int j = x; j < x + 10; j++) {
				for (int j2 = y; j2 < y + 10; j2++) {
					map[j][j2] = true;
				}
			}
		}

		// 검은 영역 세기
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == true) {
					if (j == map.length - 1 || map[i][j + 1] == false) {
						cnt++;
					}
					if (j == 0 || map[i][j - 1] == false) {
						cnt++;
					}
					if (i == map.length - 1 || map[i + 1][j] == false) {
						cnt++;
					}
					if (i == 0 || map[i - 1][j] == false) {
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);

	}
}