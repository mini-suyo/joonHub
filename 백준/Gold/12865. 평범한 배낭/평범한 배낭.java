import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int max = scanner.nextInt();

        int[] weight = new int[count + 1];
        int[] value = new int[count + 1];

        for (int i = 1; i <= count; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

        int[][] dp = new int[count + 1][max + 1];

        for (int i = 1; i <= count; i++) {
            for (int j = 0; j <= max; j++) {
                if (weight[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[count][max]);
    }
}
