import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int H = sc.nextInt();
            int W = sc.nextInt();

            char[][] map = new char[H][W];
            boolean[][] visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                String line = sc.next();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            int[] dy = {1, -1, 0, 0};
            int[] dx = {0, 0, 1, -1};

            int cnt = 0;
            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    if (map[y][x] == '#' && !visited[y][x]) {
                        cnt++;
                        ArrayDeque<int[]> q = new ArrayDeque<>();
                        visited[y][x] = true;
                        q.offer(new int[]{y, x});

                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int cy = cur[0], cx = cur[1];

                            for (int k = 0; k < 4; k++) {
                                int ny = cy + dy[k];
                                int nx = cx + dx[k];

                                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                                if (visited[ny][nx]) continue;
                                if (map[ny][nx] != '#') continue;

                                visited[ny][nx] = true;
                                q.offer(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }

            System.out.println(cnt);
        }

        sc.close();
    }
}
