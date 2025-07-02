import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행 수
        int M = sc.nextInt(); // 열 수
        int K = sc.nextInt(); // 동아리원 수
        sc.nextLine(); // 개행 제거

        int result = 0;

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            int count = 0;

            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '0') {
                    count++;
                } else {
                    if (count >= K) {
                        result += (count - K + 1);
                    }
                    count = 0;
                }
            }

            // 줄 마지막에도 연속된 '0'이 있을 수 있음
            if (count >= K) {
                result += (count - K + 1);
            }
        }

        System.out.println(result);
        sc.close();
    }
}
