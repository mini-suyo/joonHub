import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, rslt;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    // 치즈도둑처럼 풀어버려
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        int maxHeight = 0;

        // 입력 받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < arr[i][j]) {
                    maxHeight = arr[i][j];
                }
            }
        }

        // 안전영역의 최소값은 1로 설정
        rslt = 1;

        // 높이가 1인 경우부터 maxHeight인 경우까지 확인해서 최대 안전영역 개수 갱신
        for (int i = 1; i <= maxHeight; i++) {
            visited = new boolean[N + 1][N + 1];
            int cnt = 0; // 안전영역의 개수

            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    if (arr[r][c] > i && !visited[r][c]) {
                        dfs(r, c, i);
                        cnt++;
                    }
                }
            }
            if (rslt < cnt) {
                rslt = cnt;
            }
        }

        // 결과 출력
        bw.write(String.valueOf(rslt));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int r, int c, int height) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 1 && nr <= N && nc >= 1 && nc <= N && !visited[nr][nc] && arr[nr][nc] > height) {
                dfs(nr, nc, height);
            }
        }
    }
}
