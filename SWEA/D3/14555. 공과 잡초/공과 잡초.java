import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String str = sc.next();
			char[] field = str.toCharArray();

			int cnt = 0;
			for (int i = 0; i < field.length; i++) {
				if (i + 1 < field.length && field[i] == '(' && (field[i + 1] == ')' || field[i + 1] == '|')) {
					cnt++;
				}
				if (i > 0 && field[i] == ')' && field[i - 1] == '|') {
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);
		}

	}

}
