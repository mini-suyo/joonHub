import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int n = 0; n < N; n++) {

			int repeatA = sc.nextInt();
			int[] A = new int[repeatA];
			for (int i = 0; i < repeatA; i++) {
				A[i] = sc.nextInt();
			}
			int[] countA = new int[4];
			for (int i = 0; i < A.length; i++) {
				countA[A[i] - 1]++;
			}

			int repeatB = sc.nextInt();
			int[] B = new int[repeatB];
			for (int i = 0; i < repeatB; i++) {
				B[i] = sc.nextInt();
			}
			int[] countB = new int[4];
			for (int i = 0; i < B.length; i++) {
				countB[B[i] - 1]++;
			}

			for (int i = 3; i >= 0; i--) {
				if (countA[i] > countB[i]) {
					System.out.println("A");
					break;
				} else if (countA[i] < countB[i]) {
					System.out.println("B");
					break;
				}
				if (i == 0 && countA[0] == countB[0]) {
					System.out.println("D");
				}
			}

		}

	}
}