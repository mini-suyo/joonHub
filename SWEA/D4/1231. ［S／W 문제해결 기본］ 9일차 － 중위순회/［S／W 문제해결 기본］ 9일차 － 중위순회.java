import java.util.Scanner;

public class Solution {

	static String[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			tree = new String[N + 1];
			int trash = 0; // 값처리

			// N이 짝수일때

			if (N % 2 == 0) {
				for (int i = 1; i <= N; i++) {
					// N/2-1 까지는 입력 4개
					if (i < N / 2) {
						trash = sc.nextInt();
						tree[i] = sc.next();
						trash = sc.nextInt();
						trash = sc.nextInt();
					}
					// N/2는 입력 3개
					else if (i == N / 2) {
						trash = sc.nextInt();
						tree[i] = sc.next();
						trash = sc.nextInt();
					}
					// N/2+1 부터는 입력 2개
					else {
						trash = sc.nextInt();
						tree[i] = sc.next();
					}
				}
			}

			// N이 홀수일 때
			else {
				for (int i = 1; i <= N; i++) {
					// N/2까지는 입력 4개
					if (i <= N / 2) {
						trash = sc.nextInt();
						tree[i] = sc.next();
						trash = sc.nextInt();
						trash = sc.nextInt();
					}

					// N/2+1부터는 입력 2개
					else {
						trash = sc.nextInt();
						tree[i] = sc.next();
					}
				}

			}
			System.out.print("#"+t+" ");
			inorder(1);
			System.out.println();

		}

	}

	public static void inorder(int root) {
		if (root >= tree.length || tree[root] == "")
			return;
		inorder(root * 2);
		System.out.print(tree[root]);
		inorder(root * 2 + 1);
	}
}