import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), cnt = 1, space = N - 1;

		for (int i = 0; i < N; i++) {
			for (int j = space; j > 0; j--) {
				System.out.print(" ");
			}
			space--;
			for (int j = 1; j <= cnt; j++) {
				System.out.print("*");
			}
			cnt++;
			System.out.println();
		}

	}

}
