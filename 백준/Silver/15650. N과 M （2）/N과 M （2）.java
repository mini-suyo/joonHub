import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];

		function(0, 1);
	}

	static void function(int idx, int num) {
		// 기저조건
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}
		if (num > N) return;

		// 재귀부분
		// 1을 넣을게
		sel[idx] = num;
		function(idx+1, num+1);
		
		// 1을 안넣을게
		function(idx, num+1);
	}

}
