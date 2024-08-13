import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt(); // 제목의 갯수
			String[] title = new String[N];

			for (int i = 0; i < N; i++) {
				title[i] = sc.next();
			}

			Arrays.sort(title);

			int cnt = 0;

			// 처음이 A라면 cnt++;
			if (title[0].charAt(0) == 'A') {
				cnt++;
			}

			for (int i = 0; i < N - 1; i++) {
				if (title[0].charAt(0) != 'A') {
					break;
				}
				if (title[i + 1].charAt(0) - title[i].charAt(0) > 1) {
					break;
				} else if (title[i + 1].charAt(0) - title[i].charAt(0) == 1) {
					cnt++;
				}
			}
			System.out.println("#" + t + " " + cnt);

		}

	}

}
