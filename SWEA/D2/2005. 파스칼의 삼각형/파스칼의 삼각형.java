import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] pascal = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) {
					pascal[i][i] = 1;
					pascal[i][0] = 1;
					if (i > 1 && j > 0 && j < i) {
						pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
					}
				}
			}
			System.out.println("#" + t);
			for (int i = 0; i < pascal.length; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print(pascal[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}