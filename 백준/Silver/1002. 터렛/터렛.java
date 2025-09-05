import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int r1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int r2 = sc.nextInt();

            int dx = x2 - x1;
            int dy = y2 - y1;
            int dist2 = dx * dx + dy * dy;
            int sumR = r1 + r2;
            int sumR2 = sumR * sumR;
            int diffR = r1 - r2;
            int diffR2 = diffR * diffR;

            if (dist2 == 0 && r1 == r2) {
                System.out.println(-1);
            } else if (dist2 > sumR2) {
                System.out.println(0);
            } else if (dist2 == sumR2) {
                System.out.println(1);
            } else if (dist2 < diffR2) {
                System.out.println(0);
            } else if (dist2 == diffR2) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }

        sc.close();
    }
}
