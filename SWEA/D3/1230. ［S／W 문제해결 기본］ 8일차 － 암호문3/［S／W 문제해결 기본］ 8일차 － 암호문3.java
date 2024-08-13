import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int t = 1; t <= T; t++) {
			LinkedList<Integer> list = new LinkedList<>();
			int N = sc.nextInt(); // 원본 암호문의 길이
			for (int n = 0; n < N; n++) {
				list.addLast(sc.nextInt());
			}

			int M = sc.nextInt(); // 명령어의 개수
			for (int m = 0; m < M; m++) {
				String str = sc.next(); // 명령어 받기

				// I일 때
				if (str.equals("I")) {
					int X = sc.nextInt(); // 이 값 다음부터 tmp값 입력
					int Y = sc.nextInt(); // 넣어야할 숫자 갯수
					int[] tmp = new int[Y];
					for (int y = 0; y < Y; y++) {
						tmp[y] = sc.nextInt();
					}

					for (int i = 0; i < Y; i++) {
						list.add(X + i, tmp[i]);
					}
				}

				// D일 때
				if (str.equals("D")) {
					int X = sc.nextInt(); // 이 값 다음부터 tmp값 입력
					int Y = sc.nextInt(); // 넣어야할 숫자 갯수
					for (int i = 0; i < Y; i++) {
						list.remove(X + 1);
					}

				}

				// A일 때
				if (str.equals("A")) {
					int Y = sc.nextInt(); // 넣어야할 숫자 갯수
					int[] tmp = new int[Y];
					for (int y = 0; y < Y; y++) {
						tmp[y] = sc.nextInt();
						list.addLast(tmp[y]);
					}

				}

			}

			System.out.print("#" + t);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + list.get(i));
			}
			System.out.println();

		}

	}

}
