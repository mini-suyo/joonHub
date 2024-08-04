import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] cake = new int[L];

		int expMax = 0;
		int expMaxNum = 0; // 예상 최대갯수를 받는 인원
		int tmp = 0;
		int maxNum = 0; // 실제 최대갯수를 받는 인원
		for (int i = 0; i < N; i++) {
			int P = sc.nextInt();
			int K = sc.nextInt();

			// 예상 인원
			if (expMax < K - P + 1) {
				expMax = K - P + 1;
				expMaxNum = (i + 1);
			}

			// 실제 받는 사람
			int max = 0;
			for (int j = P - 1; j < K; j++) {
				if (cake[j] == 0) {
					max++;
				}
				cake[j]++;
			}
			if (tmp < max) {
				tmp = max;
				maxNum = (i + 1);
			}

		}

		System.out.println(expMaxNum + " " + maxNum);

	}
}
