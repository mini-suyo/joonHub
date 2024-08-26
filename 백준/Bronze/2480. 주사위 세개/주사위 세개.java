import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int first = sc.nextInt();
		int second = sc.nextInt();
		int third = sc.nextInt();
		int rslt = 0;

		if (first == second && second == third) {
			rslt = 10000 + first * 1000;
		} else if (first == second) {
			rslt = 1000 + first * 100;
		} else if (second == third) {
			rslt = 1000 + second * 100;
		} else if (third == first) {
			rslt = 1000 + third * 100;
		} else {
			int tmp = Math.max(first, Math.max(second, third));
			rslt = tmp * 100;
		}
		System.out.println(rslt);
	}

}
