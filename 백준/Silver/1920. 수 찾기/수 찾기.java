import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		Arrays.sort(arr);
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int number = sc.nextInt();
			int start = 0;
			int end = n - 1;
			while (true) {
				int k = (start + end) / 2;
				if (arr[k] == number) {
					System.out.println(1);
					break;
				}
				if (k <= end && k >= start && arr[k] > number)
					end = k - 1;
				else if (k <= end && k >= start && arr[k] < number)
					start = k + 1;
				else {
					System.out.println(0);
					break;
				}
			}

		}
	}
}
