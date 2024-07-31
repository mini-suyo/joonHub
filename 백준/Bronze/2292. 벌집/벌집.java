import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = 1; // 세트의 마지막 숫자
		int cnt = 1; // 이동할 거리

		for (int i = 0; i < 1000000000; i += 6) {
			if(N==1) {
				System.out.println(cnt);
				break;
			}
			
			num += i;
			
			if (N > num - i && N <= num) {
				System.out.println(cnt);
				break;
			}
			cnt++;
		}

	}
}