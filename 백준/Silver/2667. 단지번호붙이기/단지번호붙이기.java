import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count;
    static List<Integer> result = new ArrayList<>();

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }

        sc.close();
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        count++;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                if (map[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}
