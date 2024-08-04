import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		// 2차 행렬 결정하기
		int r = 1;
		for (int i = 1; i <= Math.sqrt(str.length()); i++) {
			if (str.length() % i == 0) {
				int tmp = i;
				if (r < tmp) {
					r = tmp;
				}
			}
		}
		int c = str.length() / r;

		// 메열에 메시지 넣기
		char[][] message = new char[r][c];
		int idx = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				if (idx < str.length()) {
					message[j][i] = str.charAt(idx);
					idx++;
				}

			}

		}

		// 출력
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(message[i][j]);
			}
		}
	}
}
