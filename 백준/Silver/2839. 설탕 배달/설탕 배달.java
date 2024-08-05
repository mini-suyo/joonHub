import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i <= 1667; i++) {
			for (int j = 0; j <= 1000; j++) {
				if ((i * 3 + j * 5) == N) {
					System.out.println(i + j);
					return;
				}
			}

		}
		System.out.println(-1);

	}
}