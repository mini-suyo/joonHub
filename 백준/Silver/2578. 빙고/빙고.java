import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] board = new int[5][5];
        boolean[][] visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int count = 0;
        int answer = 0;

        for (int k = 0; k < 25; k++) {
            int number = sc.nextInt();
            count++;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (board[i][j] == number) {
                        visited[i][j] = true;
                    }
                }
            }

            int bingo = 0;

            for (int i = 0; i < 5; i++) {
                if (visited[i][0] && visited[i][1] && visited[i][2] && visited[i][3] && visited[i][4]) {
                    bingo++;
                }
            }

            for (int j = 0; j < 5; j++) {
                if (visited[0][j] && visited[1][j] && visited[2][j] && visited[3][j] && visited[4][j]) {
                    bingo++;
                }
            }

            if (visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4]) {
                bingo++;
            }

            if (visited[0][4] && visited[1][3] && visited[2][2] && visited[3][1] && visited[4][0]) {
                bingo++;
            }

            if (bingo >= 3) {
                answer = count;
                break;
            }
        }
        sc.close();

        System.out.println(answer);
    }
}
