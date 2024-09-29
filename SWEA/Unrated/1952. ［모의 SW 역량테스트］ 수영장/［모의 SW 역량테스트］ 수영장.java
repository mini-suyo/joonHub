import java.util.Scanner;

public class Solution {

	static int result;
	static int[] price = new int[4], month = new int[13], dp;
	static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			init();

			dp();

			System.out.println("#" + tc + " " + result);
		}

	}

	static void init() {
		result = 0;
		// 1일권, 1달권, 3달권, 1년권 가격
		for (int i = 0; i < 4; i++) {
			price[i] = sc.nextInt();
		}
		// 각달의 이용계획
		for (int i = 1; i <= 12; i++) {
			month[i] = sc.nextInt();
		}
	}

	static void dp() {
		dp = new int[13];

		// 1월은 일 수*일일권, 한달권 중 최솟값 가져가
		dp[1] = Math.min(month[1] * price[0], price[1]);
		// 2월은 1월+일수*일일권, 1월+한달권 중 최솟값 가져가
		dp[2] = Math.min(dp[1] + month[2] * price[0], dp[1] + price[1]);
		// 3~11월은 전달+일 수*일일권, 전달+한달권, 3전달+3달권 비교
		for (int i = 3; i <= 12; i++) {
			dp[i] = Math.min(dp[i - 1] + month[i] * price[0], Math.min(dp[i - 1] + price[1], dp[i - 3] + price[2]));
			// 12월은 일년권까지 비교
			if (i == 12)
				dp[i] = Math.min(dp[i], price[3]);
		}
		result = dp[12];
	}

}
