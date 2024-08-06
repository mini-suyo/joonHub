import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이의 장수
		int[][] map = new int[1001][1001];

		int value = 1; // 각 색종이가 부여할수 있는 값(1,10,100순으로 커짐)
		for (int n = 0; n < N; n++) {
			int x = sc.nextInt(); // x좌표
			int y = sc.nextInt(); // y좌표
			int w = sc.nextInt(); // 너비
			int h = sc.nextInt(); // 높이

			for (int i = x; i < x + w; i++) {
				for (int j = y; j < y + h; j++) {
					map[i][j] = value;
				}
			}
			value *= 10;
		}

		// 각 색종이의 결과를 받을 배열
		int[] result = new int[N];
		int tmp = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map[0].length; j2++) {
					if (map[j][j2] >= tmp && map[j][j2] < tmp * 10) {
						result[i]++;
					}
				}
			}
			tmp *= 10;
			System.out.println(result[i]);
		}

	}
}