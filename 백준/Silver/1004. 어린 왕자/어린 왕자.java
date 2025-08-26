import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int ax = sc.nextInt();
            int ay = sc.nextInt();
            int bx = sc.nextInt();
            int by = sc.nextInt();

            int n = sc.nextInt();
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                int cx = sc.nextInt();
                int cy = sc.nextInt();
                int r = sc.nextInt();

                long dx1 = ax - cx;
                long dy1 = ay - cy;
                boolean inA = dx1 * dx1 + dy1 * dy1 < 1L * r * r;

                long dx2 = bx - cx;
                long dy2 = by - cy;
                boolean inB = dx2 * dx2 + dy2 * dy2 < 1L * r * r;

                if ((inA && !inB) || (!inA && inB)) {
                    cnt++;
                }
            }

            System.out.println(cnt);
        }

        sc.close();
    }
}
