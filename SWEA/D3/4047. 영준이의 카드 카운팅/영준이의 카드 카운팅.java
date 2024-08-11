import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		a: for (int t = 1; t <= T; t++) {
			String S = sc.next();
			String[] card = new String[S.length() / 3];

			int index = 0;
			for (int i = 0; i < card.length; i++) {
				card[i] = S.substring(index, index + 3);
				index += 3;
			}

			// 카드 무늬 갯수 찾기
			int spade = 13, diamond = 13, heart = 13, clover = 13;
			for (int i = 0; i < S.length(); i += 3) {
				if (S.charAt(i) == 'S') {
					spade--;
				}
				if (S.charAt(i) == 'D') {
					diamond--;
				}
				if (S.charAt(i) == 'H') {
					heart--;
				}
				if (S.charAt(i) == 'C') {
					clover--;
				}
			}

			// error 찾기
			Arrays.sort(card);
			for (int i = 0; i < card.length - 1; i++) {
				if (card[i].equals(card[i + 1])) {
					System.out.println("#" + t + " ERROR");
					continue a;
				}
			}
			System.out.println("#" + t + " " + spade + " " + diamond + " " + heart + " " + clover);
		}
	}
}