import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력값 받기
		for (int i = 0; i < 4; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();

			if (y1 > q2 || p1 < x2 || q1 < y2 || x1 > p2) { // 겹치지 않을때
				System.out.println("d");
			} else if ((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2)
					|| (p1 == x2 && y1 == q2)) { // 점이 겹칠때
				System.out.println("c");
			} else if (p1 == x2 || q1 == y2 || p2 == x1 || y1 == q2) { // 선이 닿을때
				System.out.println("b");
			} else { // 그 외 모두
				System.out.println("a");
			}
		}
	}

}