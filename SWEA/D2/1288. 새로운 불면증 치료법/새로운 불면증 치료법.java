import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		a: for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[10]; // 10개의 숫자를 카운팅할 배열
			int tmp = 1;

			while (true) {
				String str = Integer.toString(N * tmp);
				int[] digits = new int[str.length()];

				for (int i = 0; i < str.length(); i++) {
					digits[i] = Character.getNumericValue(str.charAt(i));
				}

				for (int i = 0; i < digits.length; i++) {
					int cnt = 0;
					arr[digits[i]]++;
					for (int j = 0; j < arr.length; j++) {
						if (arr[j] != 0) {
							cnt++;
							if (cnt == 10) {
								System.out.println("#" + t + " " + str);
								continue a;
							}
						}
					}
				}
				tmp++;
			}
		}

	}

}
