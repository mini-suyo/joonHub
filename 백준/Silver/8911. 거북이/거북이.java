import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int tc = 1; tc <= T; tc++) {
            String commands = sc.nextLine();
            int x = 0, y = 0;
            int dir = 0;
            int minX = 0, maxX = 0, minY = 0, maxY = 0;

            for (char c : commands.toCharArray()) {
                if (c == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                } else if (c == 'B') {
                    x -= dx[dir];
                    y -= dy[dir];
                } else if (c == 'L') {
                    dir = (dir + 3) % 4;
                } else if (c == 'R') {
                    dir = (dir + 1) % 4;
                }

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }

            int width = maxX - minX;
            int height = maxY - minY;
            System.out.println(width * height);
        }

        sc.close();
    }
}
