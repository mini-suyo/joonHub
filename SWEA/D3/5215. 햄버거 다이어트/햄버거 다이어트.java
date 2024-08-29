import java.util.Scanner;

public class Solution {

	static int N, L, rslt;
	static int[] scores, cals;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			scores = new int[N];
			cals = new int[N];

			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}

			rslt = 0;

			function(0, 0, 0);

			System.out.println("#" + tc + " " + rslt);

		}

	}

	static void function(int idx, int sumScore, int sumCal) {
		// 기저조건
		if (idx == N) {
			if (sumCal <= L && rslt < sumScore)
				rslt = sumScore;
			return;
		}
		// 재귀부분

		function(idx + 1, sumScore + scores[idx], sumCal + cals[idx]);

		function(idx + 1, sumScore, sumCal);

	}
}