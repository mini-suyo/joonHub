import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		int[] sumArr = new int[N];
		arr[0] = sc.nextInt();
		int sum = arr[0];
		sumArr[0] = arr[0];
		for (int i = 1; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
			sumArr[i] = sumArr[i - 1] + arr[i];
		}
		for (int i = 0; i < M; i++) {
			int s = sc.nextInt() - 1;
			int e = sc.nextInt() - 1;

			if (s - 1 >= 0) {
				System.out.println(sumArr[e] - sumArr[s - 1]);
			} else {
				System.out.println(sumArr[e]);
			}

		}
	}
}
