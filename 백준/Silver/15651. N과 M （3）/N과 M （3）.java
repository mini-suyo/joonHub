import java.util.Scanner;

public class Main {

	static int N, M;
	static int[] sel;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];

		function(0);
		System.out.print(sb);
	}

	static void function(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			sel[idx] = i;
			function(idx + 1);
		}

	}

}
