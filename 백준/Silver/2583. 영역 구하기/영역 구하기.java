import java.util.*;

public class Main {
    static int M, N, K;
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[M][N];
        board = new int[M][N];

        for (int i = 0; i < K; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    visited[y][x] = true;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();
        for (int y = 0; y < M; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x]) {
                    areas.add(bfs(x, y));
                }
            }
        }

        Collections.sort(areas);
        System.out.println(areas.size());
        for (int area : areas) {
            System.out.print(area + " ");
        }
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startY][startX] = true;
        queue.add(new int[]{startX, startY});
        int area = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{nx, ny});
                        area++;
                    }
                }
            }
        }

        return area;
    }
}
