import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[101][101];
        int area = 0;

        for (int r = 0; r < 4; r++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    if (board[x][y] == 0) {
                        board[x][y] = 1;
                        area++;
                    }
                }
            }
        }

        System.out.println(area);
    }
}
