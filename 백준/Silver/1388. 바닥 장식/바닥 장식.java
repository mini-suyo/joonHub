import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            board[i] = line.toCharArray();
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '-') {
                    if (!flag) {
                        count++;
                        flag = true;
                    }
                } else {
                    flag = false;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (board[i][j] == '|') {
                    if (!flag) {
                        count++;
                        flag = true;
                    }
                } else {
                    flag = false;
                }
            }
        }

        System.out.println(count);
    }
}
