import java.util.Scanner;

public class Main {

    static int N, M, r, c, d;
    static int[][] room;
    static boolean[][] cleaned;
    static int rslt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        room = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                room[i][j] = sc.nextInt();
            }
        }

        rslt = 0; // 청소한 칸의 개수
        function(r, c, d);

        System.out.println(rslt);
    }

    public static void function(int r, int c, int dir) {
        int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
        int[] dc = {0, 1, 0, -1}; 

        if (!cleaned[r][c]) {
            cleaned[r][c] = true;
            rslt++;
        }

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4; // 반시계 방향 회전

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr >= 0 && nc >= 0 && nr < N && nc < M && room[nr][nc] == 0 && !cleaned[nr][nc]) {
                function(nr, nc, dir);
                return;
            }
        }

        int back = (dir + 2) % 4; // 후진 방향
        int nr = r + dr[back];
        int nc = c + dc[back];

        if (nr >= 0 && nc >= 0 && nr < N && nc < M && room[nr][nc] != 1) {
            function(nr, nc, dir); // 후진하지만 방향 유지
        }
    }
}
