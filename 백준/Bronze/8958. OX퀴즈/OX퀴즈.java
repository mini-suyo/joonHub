import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {

			// 오답 여부를 quiz배열에 넣는다
			String str = sc.next();
			char[] quiz = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				quiz[i] = str.charAt(i);
			}

			// 점수를 넣을 배열
			int[] score = new int[str.length()];
			int bonus = 0;
			for (int i = 0; i < score.length; i++) {
				if (quiz[i] == 'O') {
					score[i] = 1 + bonus;
				}
				if ((i + 1) < score.length && quiz[i] == 'O' && quiz[i + 1] == 'O') {
					bonus++;
				}
				if ((i + 1) < score.length && quiz[i] == 'O' && quiz[i + 1] == 'X') {
					bonus = 0;
				}
			}

			int result = 0;
			for (int i = 0; i < score.length; i++) {
				result += score[i];
			}
			System.out.println(result);
		}

	}
}
