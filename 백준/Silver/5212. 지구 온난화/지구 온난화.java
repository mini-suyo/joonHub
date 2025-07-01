import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] willSink;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        map = new char[R][C];
        willSink = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'X') {
                    int sea = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '.') {
                            sea++;
                        }
                    }
                    if (sea >= 3) {
                        willSink[r][c] = true;
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (willSink[r][c]) {
                    map[r][c] = '.';
                }
            }
        }

        int minR = R, maxR = 0, minC = C, maxC = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'X') {
                    minR = Math.min(minR, r);
                    maxR = Math.max(maxR, r);
                    minC = Math.min(minC, c);
                    maxC = Math.max(maxC, c);
                }
            }
        }

        for (int r = minR; r <= maxR; r++) {
            for (int c = minC; c <= maxC; c++) {
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
    }
}
