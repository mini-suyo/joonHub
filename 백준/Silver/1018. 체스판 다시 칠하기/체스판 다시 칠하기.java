
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		// 완전탐색을 통해 최소값 찾기
		int rslt = Integer.MAX_VALUE;
		for (int i = 0; i <= N-8; i++) {
			for (int j = 0; j <= M-8; j++) {
				// 8*8칸 바꿀 부분 계산
				int wCount = 0, bCount = 0;
				for (int y = 0; y < 8; y++) {
					for (int x = 0; x < 8; x++) {
						// 1번이 W로 시작해야 하는데 B인 경우
						if ((x + y) % 2 == 0 && board[y+i][x+j] != 'W') {
							wCount++;
						}
						// 1번이 B로 시작해야 하는데 W인 경우
						if ((x + y) % 2 == 1 && board[y+i][x+j] != 'B') {
							wCount++;
						}
						
						// 1번이 B로 시작해야 하는데 W인 경우
                        if ((x + y) % 2 == 0 && board[i + y][j + x] != 'B') {
                            bCount++;
                        }
                        // 1번이 W로 시작해야 하는데 B인 경우
                        if ((x + y) % 2 == 1 && board[i + y][j + x] != 'W') {
                            bCount++;
                        }

					}
				}
				// 최소값 찾기
				if (rslt > wCount)
					rslt = wCount;
				if (rslt > bCount)
					rslt = bCount;
			}
		}
		System.out.println(rslt);

	}

}