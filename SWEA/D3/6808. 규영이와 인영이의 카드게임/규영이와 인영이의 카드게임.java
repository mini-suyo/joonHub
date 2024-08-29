import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int gyuCnt, inCnt, gyuWin, inWin;
	static int[] myDeck, otherDeck, sel;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		myDeck = new int[9];
		otherDeck = new int[9];
		visited = new boolean[10];
		sel = new int[9];

		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < myDeck.length; i++) {
				myDeck[i] = sc.nextInt();
			}
			int[] countDeck = new int[18];
			for (int i = 0; i < myDeck.length; i++) {
				countDeck[myDeck[i] - 1]++;
			}
			int idx = 0;
			for (int i = 0; i < 18; i++) {
				if (countDeck[i] == 0) {
					otherDeck[idx] = i + 1;
					idx++;
				}
			}

			function(0);
//			System.out.println(Arrays.toString(myDeck));
//			System.out.println(Arrays.toString(countDeck));
//			System.out.println(Arrays.toString(otherDeck));
			System.out.println("#" + tc + " " + gyuWin + " " + inWin);
			gyuWin = 0;
			inWin = 0;
		}

	}

	static void function(int idx) {
		// 기저조건
		if (idx == otherDeck.length) {
			// 각자의 승리수를 체크
			gyuCnt = 0;
			inCnt = 0;
			for (int i = 0; i < myDeck.length; i++) {
				if (myDeck[i] > sel[i]) {
					gyuCnt += myDeck[i] + sel[i];
				} else if (myDeck[i] < sel[i]) {
					inCnt += myDeck[i] + sel[i];
				}
			}

			// 총 승리수 계산
			if (gyuCnt > inCnt) {
				gyuWin++;
			} else if (gyuCnt < inCnt) {
				inWin++;
			}
		}

		// 재귀부분
		for (int i = 0; i < otherDeck.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				sel[idx] = otherDeck[i];
				function(idx + 1);
				visited[i] = false;
			}
		}

	}
}
