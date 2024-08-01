import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt(); // 1m당 자라는 참외의 갯수
		int[] dir = new int[12];
		int[] field = new int[12];

		for (int i = 0; i < 6; i++) { // 육각형을 만들 것!
			dir[i] = sc.nextInt(); // 방향 설정
			dir[i + 6] = dir[i]; // 예외사항 고려를 위해 복사에서 뒤에 붙힌다.
			field[i] = sc.nextInt(); // 길이 설정
			field[i + 6] = field[i]; // 예외사항 고려를 위해 복사에서 뒤에 붙힌다.
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
			if ((dir[i] == dir[i + 2]) && (dir[i + 1] == dir[i + 3])) { // 4칸반복될때가 들어간 부분
				catchA = field[i + 1];
				catchB = field[i + 2];
				break;
			}
		}
		System.out.println(((maxLength * maxWidth) - (catchA * catchB)) * K);
	}

}