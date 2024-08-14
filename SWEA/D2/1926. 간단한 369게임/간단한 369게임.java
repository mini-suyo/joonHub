import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int n = 1; n <= N; n++) {
			// n: 1~9
			if (n > 0 && n < 10) {
				if (n % 3 == 0) {
					System.out.print("- ");
				} else {
					System.out.print(n + " ");
				}
			}

			// n: 10~99
			if (n > 9 && n < 100) {
				int oneNum = n % 10;
				if (oneNum != 0 && oneNum % 3 == 0) {
					if (n / 10 == 3 || n / 10 == 6 || n / 10 == 9) {
						System.out.print("-- ");
					} else {
						System.out.print("- ");
					}
				} else if (n / 10 == 3 || n / 10 == 6 || n / 10 == 9) {
					System.out.print("- ");
				} else {
					System.out.print(n + " ");
				}

			}

			// n: 100~999
			if (n > 99 & n < 1000) {
				int cnt = 0;
				String num = Integer.toString(n);
				for (int j = 0; j < 3; j++) {
					if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
						cnt++;
					}
				}
				if (cnt == 0) {
					System.out.print(n + " ");
				} else if (cnt == 1) {
					System.out.print("- ");
				} else {
					System.out.print("-- ");
				}

			}

			// n: 1000
			if (n == 1000)
				System.out.print(n);
		}

	}
}
