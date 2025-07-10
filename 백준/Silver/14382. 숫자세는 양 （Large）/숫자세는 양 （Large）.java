import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            System.out.print("Case #" + i + ": ");
            if (N == 0) {
                System.out.println("INSOMNIA");
                continue;
            }

            boolean[] checked = new boolean[10];
            int count = 0;
            int cur = 0;

            while (count < 10) {
                cur += N;
                int temp = cur;
                while (temp > 0) {
                    int digit = temp % 10;
                    if (!checked[digit]) {
                        checked[digit] = true;
                        count++;
                    }
                    temp /= 10;
                }
            }

            System.out.println(cur);
        }
    }
}
