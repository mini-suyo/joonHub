import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mushScore = new int[10];
		int sum = 0;

		// 버섯의 점수를 10번 받기
		for (int i = 0; i < 10; i++) {
			mushScore[i] = sc.nextInt();
		}

		// 버섯의 누적합이 100이 넘을때까지 반복
		for (int i = 0; i < mushScore.length; i++) {
			int newSum = sum + mushScore[i];
			if (newSum >= 100) {	// 100 이상 일때
				if (newSum - 100 <= 100 - sum) {
					sum = newSum;
				}
				break;
			} else {
				sum = newSum;
			}
		}
		
		System.out.println(sum);
	}
}