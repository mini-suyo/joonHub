import java.util.Scanner;

public class Main {

	static int k;
	static int[] dp, coin;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		k = sc.nextInt();
		coin = new int[n];
		dp = new int[k + 1];

		// dp[1] 부터 큰값을 초기값으로 설정
		for (int i = 1; i < k + 1; i++) {
			dp[i] = 123456789;
		}

		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j < k + 1; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}

		System.out.println((dp[k] == 123456789) ? -1 : dp[k]);

	}
}
