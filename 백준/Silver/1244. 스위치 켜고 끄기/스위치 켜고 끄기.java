import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 스위치 개수 (1)
		int[] switchNum = new int[N];

		for (int i = 0; i < switchNum.length; i++) {
			switchNum[i] = sc.nextInt();
		}

		int studentNum = sc.nextInt();

		for (int i = 0; i < studentNum; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();

			// 남자일때
			if (gender == 1) {
				int tmp = num; // 배수 계산에 사용할 임시 값
				while (tmp <= N) {
					toggle(switchNum, tmp - 1);
					tmp += num;
				}
			}
			// 여자일때
			else {
				// 자기 자신은 무조건 변경
				switchNum[num - 1] = 1 - switchNum[num - 1];

				// 양옆을 확인하고 같다면 변경
				int idx = 1;
				while (true) {
					if ((num - 1 - idx >= 0 && num - 1 + idx < N)
							&& (switchNum[num - 1 - idx] == switchNum[num - 1 + idx])) {
						toggle(switchNum, num - 1 - idx);
						toggle(switchNum, num - 1 + idx);
						idx += 1;
					} else {
						break;
					}
				}

			}

		}
		for (int i = 0; i < switchNum.length; i++) {
			System.out.print(switchNum[i] + " ");
			if (((i + 1) % 20) == 0) {
				System.out.println();
			}
		}
	}

	static void toggle(int[] array, int index) {
		array[index] = 1 - array[index];
	}
}