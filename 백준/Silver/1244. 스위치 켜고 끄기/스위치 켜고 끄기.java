import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 스위치 개수 (1)
		int[] switchNum = new int[N]; // 스위치 번호 배열

		// 스위치에 초기값 부여(2)
		for (int i = 0; i < switchNum.length; i++) {
			switchNum[i] = sc.nextInt();
		}

		int Student = sc.nextInt(); // 학생 수 (3)

		// 두번 반복해서 결과 확인하기
		for (int i = 0; i < Student; i++) {
			int gender = sc.nextInt(); // 성별(4) 남자는1 여자는2로 표기
			int cnt = sc.nextInt(); // 학생이 받는 수(4)
			if (gender == 1) { // 남자일 때
				int limit = cnt;
				while (limit <= N) {
					if (switchNum[limit - 1] == 1) {
						switchNum[limit - 1]--;
					} else {
						switchNum[limit - 1]++;
					}
					limit += cnt;
				}
			}
			if (gender == 2) { // 여자일 때
				int repeatBottom = cnt - 1; // 반복횟수
				int repeatTop = N - cnt;
				int repeat = Math.min(repeatTop, repeatBottom);

				// 받은 수는 무조건 바꾼다
				if (switchNum[cnt - 1] == 1) {
					switchNum[cnt - 1]--;
				} else {
					switchNum[cnt - 1]++;
				}

				int r = 1;
				while (r <= repeat) {
					if (switchNum[cnt - r - 1] == switchNum[cnt + r - 1]) {
						if (switchNum[cnt - r - 1] == 1) {
							switchNum[cnt - r - 1]--;
						} else {
							switchNum[cnt - r - 1]++;
						}
						if (switchNum[cnt + r - 1] == 1) {
							switchNum[cnt + r - 1]--;
						} else {
							switchNum[cnt + r - 1]++;
						}

					} else {
						break;
					}

					r++;
				}

			}
		}
		for (int i = 0; i < switchNum.length; i++) {
			System.out.print(switchNum[i] + " ");
			if(((i+1) % 20) == 0) {
				System.out.println("");
			}
		}

	}
}