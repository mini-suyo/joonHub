import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();   // 한 줄 그대로 char 배열로
        }

        /* 1) 열마다 유성이 땅(#)에 닿기 전까지 최소 낙하 거리 계산 */
        int minFall = R;   // 가능한 최대 값으로 초기화
        for (int c = 0; c < C; c++) {
            int meteorBottom = -1;          // 가장 아래쪽 X
            for (int r = 0; r < R; r++) {
                if (map[r][c] == 'X') {
                    meteorBottom = r;
                } else if (map[r][c] == '#') {
                    if (meteorBottom != -1) {               // 위에 X가 있었다면
                        minFall = Math.min(minFall, r - meteorBottom - 1);
                    }
                    break;   // 이 열은 더 볼 필요 없음
                }
            }
        }

        /* 2) 결과 격자 생성 (기본 '.'), 유성은 minFall 만큼 아래로 이동 */
        char[][] result = new char[R][C];
        for (int r = 0; r < R; r++) Arrays.fill(result[r], '.');

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'X') {
                    result[r + minFall][c] = 'X';
                } else if (map[r][c] == '#') {
                    result[r][c] = '#';
                }
            }
        }

        /* 3) 출력 */
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            sb.append(result[r]).append('\n');   // char[] 바로 append 가능
        }
        System.out.print(sb.toString());
    }
}
