import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			long max = 0;
			long result = 0;
			// 뒤에서부터 최대값을 찾고 더 큰 최대값을 찾을때까지 값을 누적
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] > max) {
					max = arr[i];
				} else {
					result += max - arr[i];
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}
}