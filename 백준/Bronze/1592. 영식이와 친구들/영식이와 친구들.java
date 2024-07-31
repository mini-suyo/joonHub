import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 원형 구현은 넘을시 초기화?
		Scanner sc = new Scanner(System.in);
		int[] N = new int[sc.nextInt()]; // 원형 인원 배열(1)
		int M = sc.nextInt(); // 최대 받을 수 있는 공 횟수(2)
		int L = sc.nextInt(); // 공을 던질때 L번째로 던짐(3)

		// 받은횟수가 M이 될때까지 반복하자.
		int limit = 1; // 받은횟수 1등
		int cnt = 0; // 공을 던질 때마다 1씩 증가(출력할 것)
		N[0] = 1; // 얘는 받고 시작
		int ballMan = N[0]; // 공을 가지고있는 사람

		while (limit < M) {

			// 배열에서 최대값을 찾아 max로 저장
			for (int i = 0; i < N.length; i++) {
				if (limit < N[i]) {
					limit = N[i];
				}
			}

			int reciever = 0;
			// ballMan이 N일때 문제 발생
			// N의 값이 홀수일 때
			if (N[ballMan - 1] % 2 == 1) {
				if ((ballMan + L) % N.length == 0) {
					reciever = N.length;
				} else {
					reciever = ((ballMan + L) % N.length);
				}
				ballMan = reciever;
				N[reciever - 1]++;
				cnt++;
			} else { // N의 값이 짝수 일 때
				if ((ballMan - L) % N.length == 0) {
					reciever = N.length;
				} else {
					reciever = ((ballMan - L + N.length) % N.length);
				}
				ballMan = reciever;
				N[reciever - 1]++;
				cnt++;
			}
		}
		if (cnt == 0) {
		System.out.println(cnt);
		} else {	//cnt 초기값이 1이라서 0번이 아닌 경우를 표시
			System.out.println(cnt-1);
		}

	}

}