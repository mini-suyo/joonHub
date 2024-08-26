import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		int plus = sc.nextInt();

		// 0시를 넘어갈 때
		if ((hour + ((minute + plus) / 60)) > 23) {
			hour = (hour + ((minute + plus) / 60)) % 24;
			minute = (minute + plus) % 60;
		} else {
			hour = hour + ((minute + plus) / 60);
			minute = (minute + plus) % 60;
		}

		System.out.println(hour + " " + minute);
	}

}
