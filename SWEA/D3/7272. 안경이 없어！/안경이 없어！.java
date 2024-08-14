import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		a: for (int t = 1; t <= T; t++) {
			String firstString = sc.next();
			String secondString = sc.next();
			char[] firstCharArr = new char[firstString.length()];
			char[] secondCharArr = new char[secondString.length()];

			for (int i = 0; i < firstString.length(); i++) {
				if (firstString.charAt(i) == 'B') {
					firstCharArr[i] = '2';
				} else if (firstString.charAt(i) == 'A' || firstString.charAt(i) == 'D' || firstString.charAt(i) == 'O'
						|| firstString.charAt(i) == 'P' || firstString.charAt(i) == 'Q'
						|| firstString.charAt(i) == 'R') {
					firstCharArr[i] = '1';
				} else {
					firstCharArr[i] = '0';
				}
			}
			for (int i = 0; i < secondString.length(); i++) {
				if (secondString.charAt(i) == 'B') {
					secondCharArr[i] = '2';
				} else if (secondString.charAt(i) == 'A' || secondString.charAt(i) == 'D'
						|| secondString.charAt(i) == 'O' || secondString.charAt(i) == 'P'
						|| secondString.charAt(i) == 'Q' || secondString.charAt(i) == 'R') {
					secondCharArr[i] = '1';
				} else {
					secondCharArr[i] = '0';
				}
			}

			// 문자열 크기가 다른경우 아얘 제외
			if (firstCharArr.length != secondCharArr.length) {
				System.out.println("#" + t + " " + "DIFF");
				continue a;
			}

			for (int i = 0; i < firstCharArr.length; i++) {
				if (firstCharArr[i] != secondCharArr[i]) {
					System.out.println("#" + t + " " + "DIFF");
					continue a;
				}
			}
			System.out.println("#" + t + " " + "SAME");

		}

	}
}
