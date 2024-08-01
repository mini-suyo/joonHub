import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 카드의 개수
		int M = sc.nextInt(); // 블랙잭 리미트
		int[] card = new int[N]; // 카드의 값 배열
		int sum = Integer.MIN_VALUE; // 3장 카드의 합

		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}

		for (int i = 0; i < card.length; i++) {
			for (int j = i+1; j < card.length; j++) {	// 카드가 겹치면 안되서 초기값 설정
				for (int k = j+1; k < card.length; k++) {	// 카드가 겹치면 안되서 초기값 설정
					int tmp = card[i] + card[j] + card[k];
					if (tmp > M) {
						continue;
					}
					if (sum < tmp) {
						sum = tmp;
					}
				}
			}
		}
		
		System.out.println(sum);

	}
}