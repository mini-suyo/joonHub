import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}

			// Ai X Aj 값 구하기
			int index = 0;
			int[] newArr = new int[(N - 2) * (N - 1)];
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					newArr[index] = arr[i] * arr[j];
					index++;
				}
			}

			// 배열에서 단조 확인
			for (int i = 0; i < newArr.length; i++) {
				if (!isMonotonicIncreasing(newArr[i])) {
					newArr[i] = 0;
				}
			}
			Arrays.sort(newArr);

			if (newArr[newArr.length - 1] == 0) {
				System.out.println("#" + t + " " + -1);
			} else {
				System.out.println("#" + t + " " + newArr[newArr.length - 1]);
			}
		}
	}

	public static boolean isMonotonicIncreasing(int number) {
		int previousDigit = number % 10;
		number /= 10;

		while (number > 0) {
			int currentDigit = number % 10;
			if (currentDigit > previousDigit) {
				return false; // 단조 증가가 아님
			}
			previousDigit = currentDigit;
			number /= 10;
		}

		return true; // 단조 증가
	}

}