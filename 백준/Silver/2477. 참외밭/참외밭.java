import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 1m당 자라는 참외의 갯수
		int[] dir = new int[6];
		int[] field = new int[6];

		for (int i = 0; i < 6; i++) { // 육각형을 만들 것!
			dir[i] = sc.nextInt(); // 방향 설정
			field[i] = sc.nextInt(); // 길이 설정
		}

		int maxLength = Integer.MIN_VALUE, maxWidth = Integer.MIN_VALUE;

		for (int i = 0; i < 6; i++) {
			if (dir[i] > 2) { // 세로일때
				if (maxLength < field[i]) {
					maxLength = field[i];
				}
			} else { // 가로일때
				if (maxWidth < field[i]) {
					maxWidth = field[i];
				}
			}
		}

		int catchA = 0;
		int catchB = 0;

		for (int i = 0; i < field.length; i++) {
			if ((dir[i % 6] == dir[(i + 2) % 6]) && (dir[(i + 1) % 6] == dir[(i + 3) % 6])) { // 4칸반복될때가 들어간 부분
				catchA = field[(i + 1) % 6];
				catchB = field[(i + 2) % 6];
				break;
			}
		}
		System.out.println(((maxLength * maxWidth) - (catchA * catchB)) * K);
	}

}