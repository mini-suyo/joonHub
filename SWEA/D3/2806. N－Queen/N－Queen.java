import java.util.Scanner;

public class Solution {

	static int N, rslt;
	static int[] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			board = new int[N];

			rslt = 0;
			function(0);
			System.out.println("#" + tc + " " + rslt);

		}

	}

	static void function(int idx) {
		// 기저조건
		if (idx == N) {
			rslt++;
			return;
		}

		// 재귀부분
		// 한줄 놓고 다음 줄 놓기
		for (int i = 0; i < N; i++) {
			board[idx] = i;
			if (setQueen(idx))
				function(idx + 1);
		}

	}

	// 퀸을 놓을 수 있는지 확인, 가로부분은 function 함수에서 처리가 됬음
	static boolean setQueen(int idx) {
		for (int i = 0; i < idx; i++) {
			// 세로 확인
			if (board[idx] == board[i])
				return false;
			// 대각선 확인
			if (idx - board[idx] == i - board[i])
				return false;
			if (idx + board[idx] == i + board[i])
				return false;
		}
		return true;
	}

}
