import java.util.Scanner;

public class Solution {

	static int rslt;
	static int[] fee, plan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			fee = new int[4];
			for (int i = 0; i < 4; i++) {
				fee[i] = sc.nextInt();
			}
			plan = new int[12];
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}

			// 일년 요금을 기준으로 삼는다
			rslt = fee[3];

			function(0, 0);

			System.out.println("#" + tc + " " + rslt);

		}

	}

	static void function(int month, int sum) {
		if (rslt < sum)
			return;
		if (month > 11) {
			if (rslt > sum)
				rslt = sum;
			return;
		}

		if (plan[month] == 0) {
			function(month + 1, sum);
		} else {
			function(month + 1, sum + fee[0] * plan[month]);

			function(month + 1, sum + fee[1]);

			function(month + 3, sum + fee[2]);

		}

	}

}
