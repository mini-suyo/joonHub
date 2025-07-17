import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] map = new int[N][N];

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int r = 0, c = 0, dir = 0;
        int num = N * N;

        int targetRow = 0;
        int targetCol = 0;

        while (num >= 1) {
            map[r][c] = num;
            if (num == K) {
                targetRow = r + 1;
                targetCol = c + 1;
            }

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0) {
                dir = (dir + 1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
            num--;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(targetRow + " " + targetCol);
    }
}
