import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			System.out.println("#" + T + " " + function(N, M));

		}

	}

	static int function(int N, int M) {
		// 기저조건
		if (M == 1)
			return N;

		// 재귀부분
		if (M % 2 == 0) {
			int tmp = function(N, M / 2);
			return tmp * tmp;
		} else {
			int tmp = function(N, (M - 1) / 2);
			return tmp * tmp * N;
		}

	}

}
